package week_3.file_handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;

import java.io.*;

public class Warning {
  // --------------------------------------------------------------------
  // Reads student data (name, semester hours, quality points) from a
  // text file, computes the GPA, then writes data to another file
  // if the student is placed on academic warning.
  // --------------------------------------------------------------------
  static boolean defaulters(double gpa, int creditHrs) {
    return ((creditHrs < 30 && gpa < 1.5) || (creditHrs < 60 && gpa < 1.75) || (gpa < 2.0));
  }

  public static void main(String[] args) {
    int creditHrs; // number of semester hours earned
    double qualityPts; // number of quality points earned
    double gpa; // grade point (quality point) average
    String name, inputName = "week_3/file_handling/students.dat";

    String outputName = "warning.dat";

    try (FileWriter fw = new FileWriter(outputName); Scanner s = new Scanner(new File(inputName));) {
      while (s.hasNextLine()) {
        String[] arg = s.nextLine().split("\\s");
        name = arg[0];
        creditHrs = Integer.parseInt(arg[1]);
        qualityPts = Double.parseDouble(arg[2]);
        gpa = qualityPts / creditHrs;
        if (defaulters(gpa, creditHrs)) {
          fw.write(name + " " + creditHrs + " " + qualityPts + "\n");
        }
      }

      // Close output file
    } catch (FileNotFoundException exception) {
      System.out.println("The file " + inputName + " was not found.");
    } catch (IOException exception) {
      System.out.println(exception);
    } catch (NumberFormatException e) {
      System.out.println("Format error in input file: " + e);
    }

  }
}