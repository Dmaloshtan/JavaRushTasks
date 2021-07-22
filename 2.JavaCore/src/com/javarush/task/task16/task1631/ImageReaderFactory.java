package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes jpg) {

        if(jpg == null){
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        ImageReader imageReader = null;

        if(jpg.equals(ImageTypes.BMP)){
            imageReader = new BmpReader();
        } else if(jpg.equals(ImageTypes.JPG)){
            imageReader = new JpgReader();
        } else if(jpg.equals(ImageTypes.PNG)){
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }



        return imageReader;
    }
}
