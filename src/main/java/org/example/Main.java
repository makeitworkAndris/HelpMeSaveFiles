package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        final File folder1 = new File("D:/Andris/Phone backup");
        listFilesForFolder(folder1);
    }

    public static void listFilesForFolder(final File folder) throws IOException, ParseException {

        //FileEntry = directory or file
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                //listFilesForFolder(fileEntry);
                BasicFileAttributes attr = Files.readAttributes(fileEntry.toPath(), BasicFileAttributes.class);
                FileTime fileTime = attr.creationTime();
                System.out.println("Name: " + fileEntry +"  Time: "+ fileTime);

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String goodDateFormat = df.format(fileTime.toMillis());
                System.out.println(goodDateFormat);
            } else {
                //System.out.println(fileEntry.getName());
            }
        }
    }
}