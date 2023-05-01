/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stlmma;

import NLP.Document;
import SQL.DatabaseOperations;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Omar
 */
public class Stlmma {
    static Document token;

    public static void main(String[] args) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        double[][] matrix = databaseOperations.getMatrix(); //get matrix from db
        double[][] reducedMatrix = reduceMatrix(matrix); //reduce matrix
        printMatrix(reducedMatrix); //print reduced matrix

    }
    //create a method that eliminates the numbers from the diagonal of the matrix s and returns the matrix s
    public static double[][] eliminateNumbers(double[][] matrix, double number) {
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
          if(matrix[i][i] > number)
              newMatrix[i][i] = matrix[i][i];
          else
              newMatrix[i][i] = 0;
        }
        return newMatrix;
    }
    public static void printFormatedMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%1.0f ", Math.abs(element));
            }
            System.out.println();
        }
    }
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%f ", element);
            }
            System.out.println();
        }
    }
    public static double[][] reduceMatrix(double[][] matrix){
        RealMatrix realMatrix = MatrixUtils.createRealMatrix(matrix);
        SingularValueDecomposition svd = new SingularValueDecomposition(realMatrix); //calcula svd
        double[][] matrixS = svd.getS().getData(); //imprime matriz s
        double[][] reducedS = eliminateNumbers(matrixS, 2); //elimina numeros de la diagonal de la matriz s
        double[][] reducedSVD = svd.getU().multiply(MatrixUtils.createRealMatrix(reducedS)).multiply(svd.getVT()).getData(); //calcula la matriz reducida
        for(int i = 0; i < reducedSVD.length; i++){
            for(int j = 0; j < reducedSVD[0].length; j++){
                reducedSVD[i][j] = Math.round(Math.abs(reducedSVD[i][j]));
            }
        }
        return reducedSVD;

    }
    public static void fillDataBase() {
        List<String> title = new ArrayList<String>();
        List<String> author = new ArrayList<String>();
        List<String> location = new ArrayList<String>();
        //1
        title.add("The Benefits of Physical Activity and Positive Mental Health for Reducing the Burden of COVID-19: Validation from a Cross-sectional and Longitudinal Investigation in China and Germany.");
        author.add("International Journal of Mental Health & Addiction");
        location.add("https://doi-org.udlap.idm.oclc.org/10.1007/s11469-021-00653-5");
//        2
        title.add("What is depression and what can I do about it? Medical News Today");
        author.add("Goldman, L.");
        location.add("https://www.medicalnewstoday.com/articles/8933");
//        3
        title.add("Improvement of Millennial Generation Mental Health Due to Pandemic Effects");
        author.add("Oktaviani, S., Shalsabilla, R. Y., Nurhalyza, F., & Sitinjak, C");
        location.add("Journal of Social Science");
//        4
        title.add("Mental Health: Services, Assessment and Perspectives");
        author.add("Carlson, C");
        location.add("https://eds-s-ebscohost-com.udlap.idm.oclc.org/eds/detail/detail?vid=0&sid=c4e182ea-5ed9-4d13-bf96-aa155c64e296%40redis&bdata=Jmxhbmc9ZXMmc2l0ZT1lZHMtbGl2ZQ%3d%3d##AN=1562813&db=e000xww");
//        5
        title.add("Mental Health : The Inclusive Church Resource");
        author.add("Inclusive Church.");
        location.add("https://udlap.idm.oclc.org/login?url=https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=e000xww&AN=810883&lang=es&site=eds-live");
//        6
        title.add("Global Mental Health. [electronic resource] : Prevention and Promotion ");
        author.add("Bährer-Kohler, S., & Carod-Artal, F. J.");
        location.add("https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=cat00047a&AN=udlap.000368603&lang=es&site=eds-live");
//        7
        title.add("Why We Need a Revolution in Mental Health Care ");
        author.add("Peter Kinderman");
        location.add("https://udlap.idm.oclc.org/login?url=https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=cat00047a&AN=udlap.000369024&lang=es&site=eds-live");
//        8
        title.add("Well-Being Concepts");
        author.add("National Center for Chronic Disease Prevention and Health Promotion");
        location.add("https://www.cdc.gov/hrqol/wellbeing.htm");
//        9
        title.add("Why Integrated Behavioral Health Care for Children and Adolescents Matters");
        author.add("");
        location.add("https://clinicalconnection.hopkinsmedicine.org/news/why-integrated-behavioral-health-care-for-children-and-adolescents-matters");
//        10
        title.add("Mental illness");
        author.add("Mayo Clinic");
        location.add("https://www.mayoclinic.org/diseases-conditions/mental-illness/symptoms-causes/syc-20374968");


//        Inserta Titulos, terminos y apariciones en base de datos
        /*for (int i = 0; i < title.size(); i++) {
            token = new Document(title.get(i), author.get(i), location.get(i));
        }*/

    }
}