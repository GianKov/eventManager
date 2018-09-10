package com.eventManager;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;


public class QRCodeGenerator {
    public String getQRCodeByString(String id) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter=new QRCodeWriter();
        BitMatrix bitMatrix=qrCodeWriter.encode(id, BarcodeFormat.QR_CODE, 150, 150);
        ByteArrayOutputStream pngOutput=new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix,"PNG",pngOutput);
        byte[] pngData=pngOutput.toByteArray();
        byte[] encoded= Base64.getEncoder().encode(pngData);
        String base64encoded=new String(encoded,"UTF-8");
        //System.out.println(encoded);
        return base64encoded;
    }
}
