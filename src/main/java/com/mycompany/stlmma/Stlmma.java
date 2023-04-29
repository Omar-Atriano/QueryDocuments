/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stlmma;

import NLP.Document;
import SQL.DatabaseOperations;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omar
 */
public class Stlmma {
    static Document token;

    public static void main(String[] args) {
        System.out.println("Hello ");
        fillDataBase();


//DatabaseOperations op = new DatabaseOperations();
//List<String> terminos = new ArrayList<String>();
//try{
//    terminos = op.getTerms();
//}catch(SQLException e){
//    e.printStackTrace();
//}
//for(String elemento :terminos){
//    System.out.println(elemento);
//}

    }
    
    public static void fillDataBase(){
        String title = new String();
        String author = new String();
        String location = new String();
        
//        10 Documentos agregados
//        1
        title ="The Benefits of Physical Activity and Positive Mental Health for Reducing the Burden of COVID-19: Validation from a Cross-sectional and Longitudinal Investigation in China and Germany.";
        author = "International Journal of Mental Health & Addiction";
        location="https://doi-org.udlap.idm.oclc.org/10.1007/s11469-021-00653-5";
//        2
//        title ="What is depression and what can I do about it? Medical News Today";
//        author="Goldman, L.";
//        location ="https://www.medicalnewstoday.com/articles/8933";
//        3
//        title="Improvement of Millennial Generation Mental Health Due to Pandemic Effects";
//        author="Oktaviani, S., Shalsabilla, R. Y., Nurhalyza, F., & Sitinjak, C";
//        location="Journal of Social Science";
//        4
//        title="Mental Health: Services, Assessment and Perspectives";
//        author ="Carlson, C";
//        location = "https://eds-s-ebscohost-com.udlap.idm.oclc.org/eds/detail/detail?vid=0&sid=c4e182ea-5ed9-4d13-bf96-aa155c64e296%40redis&bdata=Jmxhbmc9ZXMmc2l0ZT1lZHMtbGl2ZQ%3d%3d##AN=1562813&db=e000xww";
//        5
//        title ="Mental Health : The Inclusive Church Resource";
//        author = "Inclusive Church.";
//        location = "https://udlap.idm.oclc.org/login?url=https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=e000xww&AN=810883&lang=es&site=eds-live";
//        6
//        title = "Global Mental Health. [electronic resource] : Prevention and Promotion ";
//        author = "Bährer-Kohler, S., & Carod-Artal, F. J.";
//        location = "https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=cat00047a&AN=udlap.000368603&lang=es&site=eds-live";
//        7
//        title = "Why We Need a Revolution in Mental Health Care ";
//        author = "Peter Kinderman";
//        location = "https://udlap.idm.oclc.org/login?url=https://search-ebscohost-com.udlap.idm.oclc.org/login.aspx?direct=true&db=cat00047a&AN=udlap.000369024&lang=es&site=eds-live";
//        8
//        title = "Well-Being Concepts";
//        author ="National Center for Chronic Disease Prevention and Health Promotion";
//        location ="https://www.cdc.gov/hrqol/wellbeing.htm";
//        9
//        title = "Why Integrated Behavioral Health Care for Children and Adolescents Matters";
//        author = "";
//        location = "https://clinicalconnection.hopkinsmedicine.org/news/why-integrated-behavioral-health-care-for-children-and-adolescents-matters";
//        10
//        title ="Mental illness";
//        author = "Mayo Clinic";
//        location = "https://www.mayoclinic.org/diseases-conditions/mental-illness/symptoms-causes/syc-20374968";
        
        
//        Inserta Titulos, terminos y apariciones en base de datos
        token =new Document(title,author,location);
    }
}