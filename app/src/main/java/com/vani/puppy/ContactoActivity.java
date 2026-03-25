package com.vani.puppy;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    private TextInputEditText etNombre;
    private TextInputEditText etCorreo;
    private TextInputEditText etMensaje;
    private MaterialButton btnEnviarComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviarComentario = findViewById(R.id.btnEnviarComentario);

        btnEnviarComentario.setOnClickListener(v -> validarYEnviar());
    }

    private void validarYEnviar() {
        String nombre = etNombre.getText() != null ? etNombre.getText().toString().trim() : "";
        String correo = etCorreo.getText() != null ? etCorreo.getText().toString().trim() : "";
        String mensaje = etMensaje.getText() != null ? etMensaje.getText().toString().trim() : "";

        if (TextUtils.isEmpty(nombre)) {
            etNombre.setError("Ingresá tu nombre");
            etNombre.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(correo) || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingresá un correo válido");
            etCorreo.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mensaje)) {
            etMensaje.setError("Ingresá un mensaje");
            etMensaje.requestFocus();
            return;
        }

        enviarCorreo(nombre, correo, mensaje);
    }

    private void enviarCorreo(String nombre, String correo, String mensajeUsuario) {
        final String remitente = "TU_CORREO@gmail.com";
        final String clave = "TU_APP_PASSWORD";
        final String destinatario = "TU_CORREO@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

        new Thread(() -> {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(remitente));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                message.setSubject("Comentario desde MascotasApp");

                String cuerpo = "Nombre: " + nombre
                        + "\nCorreo: " + correo
                        + "\n\nMensaje:\n" + mensajeUsuario;

                message.setText(cuerpo);

                Transport.send(message);

                runOnUiThread(() -> {
                    Toast.makeText(ContactoActivity.this, "Correo enviado correctamente", Toast.LENGTH_LONG).show();
                    etNombre.setText("");
                    etCorreo.setText("");
                    etMensaje.setText("");
                });

            } catch (Exception e) {
                runOnUiThread(() ->
                        Toast.makeText(ContactoActivity.this, "Error al enviar correo", Toast.LENGTH_LONG).show()
                );
                e.printStackTrace();
            }
        }).start();
    }
}