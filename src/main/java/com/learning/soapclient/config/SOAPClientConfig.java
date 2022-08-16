//package com.learning.soapclient.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;
//
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.TrustManagerFactory;
//import java.io.IOException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.UnrecoverableKeyException;
//import java.security.cert.CertificateException;
//
//@Configuration
//public class SOAPClientConfig {
//
//    @Value("${app.keystore}")
//    private Resource keyStore;
//
//    @Value("${keystore.password}")
//    private String keyStorePassword;
//
//    @Value("${app.truststore}")
//    private Resource trustStore;
//
//    @Value("${truststore.password}")
//    private String trustStorePassword;
//
//
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com.learning");
//        return marshaller;
//    }
//
//    @Bean
//    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) throws NoSuchAlgorithmException, KeyStoreException, IOException, UnrecoverableKeyException, CertificateException {
//        SOAPConnector client = new SOAPConnector();
//        client.setDefaultUri("https://localhost:9001/service/student-detail");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//
//        KeyStore ks = KeyStore.getInstance("JKS");
//        ks.load(keyStore.getInputStream(), keyStorePassword.toCharArray());
//
//        try {
//            keyStore.getInputStream().close();
//        } catch (IOException e) {
//        }
//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        keyManagerFactory.init(ks, keyStorePassword.toCharArray());
//
//        KeyStore ts = KeyStore.getInstance("JKS");
//        ts.load(trustStore.getInputStream(), trustStorePassword.toCharArray());
//        try {
//            trustStore.getInputStream().close();
//        } catch(IOException e) {
//        }
//        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//        trustManagerFactory.init(ts);
//
//        HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
//        messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
//        messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());
//
//        // otherwise: java.security.cert.CertificateException: No name matching localhost found
//        messageSender.setHostnameVerifier((hostname, sslSession) -> {
//            if (hostname.equals("localhost")) {
//                return true;
//            }
//            return false;
//        });
//
//        client.setMessageSender(messageSender);
//        return client;
//    }
//}
