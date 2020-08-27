import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main (String[] args) throws IOException {

        int i=0,k=0;
        int mutlakFark=0, enKucukFark=100;
        int tutulanIndis=0;
        int anlikFark=0;
        int yakinSayac=0;
        int yakinPuan=0;
        int tutulanIndis2=0;
        int diziSayac=0, underGraduateSayac=0, graduateSayac=0, sayac=0, sayac2=0, sayac3=0, sayac4=0;
        Student[] student= new Student[200]; //ogrenci sayısı 200 girince null pointer exception hatası veriyor 5 girersek vermiyor
        Integer[][] puanlama=new Integer[200][5];
        Float[] yapayZekaSum=new Float[5];
        Integer[] d3=new Integer[5];
        Float[] Average=new Float[5];
        Float[] UnderGraduateSum=new Float [5];
        Float[] UnderGraduateAverage=new Float[5];
        Float[] GraduateSum=new Float[5];
        Float[] GraduateAverage=new Float[5];
        Float[] sum2=new Float[5];
        Student[] student2=new Student[200]; //kullanıcıdan öğrenci bilgilerini alarak oluşturulan dizi
        Float[][] puanlama2= new Float[200][5]; //kullanıcıdan veri girişi alarak oluşturulan puanlama matrisi
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        Scanner s6= new Scanner(System.in);
        Scanner s7 = new Scanner(System.in);
        Scanner s8 = new Scanner(System.in);
        Scanner s9 = new Scanner(System.in);
        Scanner s10 = new Scanner(System.in);
        Scanner s11 = new Scanner(System.in);


        //Dosyadan okuma islemeri
        File file = new File("Kurum.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();

        while (satir!=null) {
            if (sayac%2!=0) {

                          String[] s=satir.split(",");

                          //lisans ogrencilerinin bilgilerini dosyadan okuyup virgüle gore parcalanmıs halıyle
                          // lisans ogrencisi nesnesi olusturup student dizisine atama
                            if (s[0].equals("u")) {
                                                UnderGraduate underGraduate=new UnderGraduate();
                                                underGraduate.setStudentID(Integer.parseInt(s[1]));
                                                underGraduate.setName(s[2]);
                                                underGraduate.setSurname(s[3]);
                                                underGraduate.setTrack(s[4]);
                                                student[diziSayac]=underGraduate;
                                                underGraduateSayac++;

                                                //lisans ogrencilerinden yapay zeka patikasını izleyen ogrenci indeksi
                                                if(underGraduate.getTrack().equals("Yapay zeka")){
                                                    d3[sayac4]=diziSayac;
                                                    sayac4++;
                                                }

                            }
                            else {
                                //lisansüstü ogrencilerinin bilgilerini dosyadan okuyup virgüle gore parcalanmıs halıyle
                                // lisansüstü ogrencisi nesnesi olusturup student dizisine atama
                                Graduate graduate=new Graduate();
                                graduate.setStudentID(Integer.parseInt(s[1]));
                                graduate.setName(s[2]);
                                graduate.setSurname(s[3]);
                                graduate.setSubject(s[4]);
                                graduate.setAdvisor(s[5]);
                                student[diziSayac]=graduate;
                                graduateSayac++;
                            }
                            diziSayac++;

                           i++;

                            }
            //puanlama için matris oluşturuluyor
            else{
                if (i!=0) {
                    String[] s=satir.split(",");
                    for(int j=0;j<s.length;j++)
                        puanlama[k][j]=Integer.parseInt(s[j]);
                         k++;
                }
            }
            sayac++;
            i++;
            satir = reader.readLine();
        }


        System.out.printf("\n -------------- \n -------------- \n -------------- \n ");

      //  1) Her bir öğretim eleman için o öğretim elemanına ait
        // ortalama derecelendirme puanının hesaplanması

        Float[] sum = new Float[5];
        //Ogretim gorevlisine verilen puanların toplamı
        for(k = 0 ; k<5; k++){
            sum[k]=(float)0;
        }
        //ogretim gorevlilerinin toplam puanı bulunuyır
        for(i=0;i<student.length;i++){
            for(k = 0 ; k<5; k++){
              if (puanlama[i][k]!=null)  sum[k] += puanlama[i][k]; //if koydum nullpointer exeption için
            }
        }
        //ogretim gorevlilerinin ortalama puanı bulunuyor
            for(k = 0 ; k<5; k++){
                Average[k]=sum[k]/diziSayac;
                System.out.printf("\n" +(k+1)+". öğretim görevlisinin ortalama puanı="+Average[k]);
    }


    Integer[] d1=new Integer[underGraduateSayac]; // bu dizide kaçıncı indekslerin undergraduate olduğunu tutacağız
    Integer[] d2=new Integer[graduateSayac]; //    kaçıncı indeks graduate olduğu bilgisini tutan dizi



        System.out.printf("\n \n -------------- \n -------------- \n -------------- \n ");

       //2) Her bir öğretim elemanı için sadece lisans öğrencilerini
        // dikkate alarak elde edilen ortalama derecelendirme puanının hesaplanması

    for(i=0;i<5;i++){
        UnderGraduateSum[i]=(float)0;
        GraduateSum[i]=(float)0;
        yapayZekaSum[i]=(float)0;
    }
    //student dizisindeki ogrencilerden hangi indekslerdeki ogrenciler lisans ogrencisi
    for(i=0;i<student.length;i++){
        if (student[i] instanceof  UnderGraduate){
            d1[sayac2]=i;
            sayac2++;
        }
    }
        for(k=0;k<5;k++){ //k ogretım gorevlısı ıcın sayac
        for(i=0;i<d1.length;i++){ //lısans ogrencılerı ıcın sayac
                UnderGraduateSum[k] += puanlama[d1[i]][k];
            }
        }

        //ogretım elemanlarının lisans ogrencılerınden aldıkları puan ortalaması bulunup yazdırılıyor.
        for(k=0;k<5;k++){
            UnderGraduateAverage[k]=UnderGraduateSum[k]/underGraduateSayac;
            System.out.printf("\n"+(k+1)+". ogretim uyesinin lisans öğrencilerinden aldığı puan ortalaması=" +UnderGraduateAverage[k]);
        }


        System.out.printf("\n\n -------------- \n -------------- \n -------------- \n ");

//3) Her bir öğretim elemanı için sadece lisansüstü öğrencileri
// dikkate alarak elde edilen ortalama derecelendirme puanı hesaplanması

        //student dizisindeki yüksek lisans ogrencılerinin indeksleri d2 dizisine atanıyor
        for(i=0;i<student.length;i++){
            if (student[i] instanceof  Graduate){
                d2[sayac3]=i;
                sayac3++;

            }
        }
        //ogretim elemanlarının yuksek lisans ogrencilerinden aldıkları toplam puan bulunuyor
        for(k=0;k<5;k++){
            for(i=0;i<d2.length;i++){
                GraduateSum[k] += puanlama[d2[i]][k];
            }
        }
        //ogretim elemanlarının yuksek lisans ogrencilerinden aldıkları ortalama puan yazdırılıyor
        for(k=0;k<5;k++){
            GraduateAverage[k]=GraduateSum[k]/graduateSayac;
            System.out.printf("\n"+(k+1)+". ogretim uyesinin yüksek lisans öğrencilerinden aldığı puan ortalaması=" + GraduateAverage[k]);
        }


        System.out.printf("\n\n -------------- \n -------------- \n -------------- \n ");

    // 4)  Her bir öğretim elemanı için sadece lisans öğrencilerinden
        // izlediği patika yapay zeka olanlar dikkate alınarak
        // elde edilen ortalama derecelendirme puanını
        for(k=0;k<5;k++){ //k ogretim elemanı sayacı
            for(i=0;i<d3.length;i++){
                if(d3[i]!=null)
                    yapayZekaSum[k] += puanlama[d3[i]][k];
            }
        }
        for(k=0;k<5;k++){
            System.out.printf("\n"+(k+1)+". ogretim uyesinin sadece lisans öğrencilerinden izlediği patika yapay zeka olan öğrencilerinden aldığı puan ortalaması=" + yapayZekaSum[k]/sayac4);
        }


        System.out.printf("\n\n -------------- \n -------------- \n -------------- \n ");

        //5) Her bir öğretim elemanı için, o öğretim elemanına ait
        // ortalama derecelendirmenin altında puan vermiş olan
        // lisans öğrencilerinin bilgilerini
        for(k=0;k<5;k++){
                 System.out.printf("\n"+(k+1)+". öğretim üyesine ortalamanın altında puan veren lisans öğrencilerin bilgileri \n");
               for(i=0;i<d1.length;i++){
                if (puanlama[d1[i]][k]<Average[k]){

                    System.out.println(student[d1[i]].toString());
                }
            }
        }


        System.out.printf("\n -------------- \n -------------- \n -------------- \n ");

        //6) Her bir öğretim elemanı için, o öğretim elemanına ait
        // ortalama derecelendirmenin altında puan vermiş
        // olan lisansüstü öğrencilerin bilgilerini
        for(k=0;k<5;k++){
            System.out.printf("\n"+(k+1)+". öğretim üyesine ortalamanın altında puan veren yüksek lisans öğrencilerin bilgileri \n");
            for(i=0;i<d2.length;i++){
                if (puanlama[d2[i]][k]<Average[k]){
                    System.out.println(student[d2[i]].toString());
                }
            }
        }

        //7) Kullanıcıdan veri girişi alarak öğrencinin 5. öğretim elemanına verdiği puanı tahmin etme


        sayac=0; //student2 dizisinin öğrenci sayısını tutar
        int studentId;
        String cikis = "E";
        String studentName, studentSurname, studentTrack, studentSubject, studentAdvisor;
        while(sayac<200 && (cikis.equals("E")) ||cikis.equals("e")){
            System.out.println("\n Ogrenci tipi giriniz. u/g");
            String ogrenciTip = s1.nextLine();
            //öğrenci tipi u ise undergraduate nesne oluşturur ve student2 dizisine atar
            if (ogrenciTip.equals("u")) {
                        System.out.println("\n Ogrenci numarası giriniz.");
                        studentId=s2.nextInt();
                        System.out.println("\n Ogrenci adı giriniz.");
                        studentName=s3.nextLine();
                        System.out.println("\n Ogrenci soyadı giriniz.");
                        studentSurname=s4.nextLine();
                        System.out.println("\n Ogrenci track name giriniz.");
                        studentTrack=s5.nextLine();
                        UnderGraduate underGraduate2=new UnderGraduate();
                        underGraduate2.setStudentID(studentId);
                        underGraduate2.setName(studentName);
                        underGraduate2.setSurname(studentSurname);
                        underGraduate2.setTrack(studentTrack);
                        student2[sayac]=underGraduate2;

            }
            //öğrenci tipi g ise graduate nesne oluşturur ve student2 dizisine atar
            else {
                      System.out.println("\n Ogrenci numarası giriniz.");
                      studentId=s6.nextInt();
                      System.out.println("\n Ogrenci adı giriniz.");
                      studentName=s7.nextLine();
                      System.out.println("\n Ogrenci soyadı giriniz.");
                      studentSurname=s8.nextLine();
                      System.out.println("\n Ogrenci subject giriniz.");
                      studentSubject=s9.nextLine();
                      System.out.println("\n Ogrenci advisor giriniz.");
                      studentAdvisor=s10.nextLine();
                      Graduate graduate2=new Graduate();
                      graduate2.setStudentID(studentId);
                      graduate2.setName(studentName);
                      graduate2.setSurname(studentSurname);
                      graduate2.setSubject(studentSubject);
                      graduate2.setAdvisor(studentAdvisor);
                      student2[sayac]=graduate2;

            }

            //kullanıcıdan her öğretim elemanı için puan girmesi istenir
            for(i=0;i<4;i++){
                System.out.println("\n"+(i+1)+". öğretim elemanı için puan giriniz.");
                puanlama2[sayac][i]=s11.nextFloat();

            }

         //verilen formüle göre 5. öğretim elemanına verilen puanı hesaplama
            for(i=0;i<5;i++){
                for(int j=0;j<4;j++){
                    mutlakFark+=  Math.abs(puanlama2[sayac][j]-puanlama[i][j]);
                }

                if(mutlakFark<enKucukFark) {
                    tutulanIndis=i;
                    enKucukFark = mutlakFark;
                }

                mutlakFark=0;

            }

            for (i=0;i<5;i++){
                for(int j=0;j<4;j++){
                    anlikFark+=  Math.abs(puanlama2[sayac][j]-puanlama[i][j]);
                }
                if (enKucukFark==anlikFark){
                    tutulanIndis2=i;
                    yakinSayac++;
                    yakinPuan+=puanlama[tutulanIndis2][4];
                }
                anlikFark=0;
            }

            if(yakinSayac>=2)
                puanlama2[sayac][4]= (float)yakinPuan/yakinSayac;
            else
               puanlama2[sayac][4]= (float)puanlama[tutulanIndis][4];

           sayac++;
           System.out.println("\n Devam etmek için E Çıkmak için herhangi bir tuşa basınız:");
           cikis = s1.nextLine();



        }

        //kullanıcının girdiği her öğrencinin 5. öğretim elemanına verdiği puan
        for (i=0;i<sayac;i++){

                System.out.printf("\n"+(i+1)+". ögrencinin 5. Ogretim elemanina verdiği puan ="+puanlama2[i][4]);

        }


        System.out.printf("\n -------------- \n -------------- \n -------------- \n ");

        // 8) Klavyeden giriş yapılan öğrencilerin bilgilerini yazdırılır.

        for(i=0;i<sayac;i++){
           System.out.println(student2[i].toString());
        }

        //klavyeden girilen öğrencilerin öğretim elemanlarına berdiği toplam puan hesaplanır ve ortalaması yazdırılır
        for(k = 0 ; k<5; k++){
            sum2[k]=(float)0;
        }
        for(i=0;i<sayac;i++){
            for(k = 0 ; k<5; k++){
                sum2[k] += puanlama2[i][k];
            }
        }
        for(k = 0 ; k<5; k++){

            System.out.printf("\n" +(k+1)+". öğretim görevlisinin ortalama puanı="+(sum2[k]/sayac));
        }



    }
}
