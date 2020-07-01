package com.publicept;

import com.publicept.Auto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AutoSerialisieren {

  public static void main(String[] args) {

    Auto a1 = new Auto("Rot", new Motor(1200));
    a1.setNummer("ZH 123");

    try (FileOutputStream fos = new FileOutputStream("/Volumes/GoogleDrive/My Drive/homes/alu/my_docs/dev/intellij-projects/edu_zhaw-advanced-java-course/005.1_BeispielCodeUebung1bis4/serialize/auto.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

      oos.writeObject(a1);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
