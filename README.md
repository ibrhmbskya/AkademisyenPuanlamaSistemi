# PuanlamaSistemi
Öğretim Elemanı Puanlama Sistemi

Lisans ve lisansüstü öğrencileri olan bir eğitim kurumunun, öğretim elemanları hakkında
öğrencilerinin yaptığı derecelendirmeleri (ratings) bir dosyada sakladığı varsayılmaktadır. Kurum,
bu derecelendirmeler ile ilgili olarak çeşitli hesaplamalar, işlemler, raporlamalar yapmak
istemektedir. Ayrıca, girilmeyen bir derecelendirme puan değeri için tahmin de yapılacaktır. Bu
bağlamda aşağıda detaylı olarak verilen gereksinimleri karşılayacak Java kodlarını yazınız.

Öğrencileri temsilen kalıtım (inheritance) kullanılarak bir sınıf hiyerarşisi oluşturulacaktır:
“Student” sınıfı, öğrenci numarasını temsil etmek için int tipinde “studentID” değişkeni ile, ad ve
soyadı temsilen String tipinde “Name” ve “Surname” değişkenlerine sahiptir. “Student sınıfı için;
parametresiz “constructor”, tüm değişkenleri kullanan “constructor” ve “copy constructor” metotları
ile “toString” metodunu yazınız. Get ve Set metotlarını otomatik olarak oluşturunuz.
Lisans öğrencilerini temsil etmek için “Student” sınıfından kalıtım ile “UnderGraduate” isimli bir sınıf
türetiniz. “UnderGraduate” sınıfında öğrencinin eğitim kurumunda izlediği akademik patikayı (track)
(yazılım mühendisliği, yapay zeka, gömülü sistemler gibi…) temsilen String tipinde “track”
değişikeni bulunmaktadır. “UnderGraduate” sınıfı için ayrıca, yukarıda söz edilen üç adet
“constructor” metot ve “toString” metodu yazılmalıdır. Get ve Set metotlarını otomatik olarak
oluşturunuz.
Lisansüstü öğrencileri temsil etmek için “Student” sınıfından kalıtım ile “Graduate” isimli bir sınıf
türetiniz. “Graduate” sınıfında öğrencinin tez konusunu temsilen String tipinde “subject” değişkeni
ile tez danışmanını temsilen String tipinde “advisor değişkenleri bulunmaktadır. “Graduate” sınıfı
için ayrıca, yukarıda söz edilen üç adet “constructor” metot ve “toString” metodu yazılmalıdır. Get
ve Set metotlarını otomatik olarak oluşturunuz.
Not: Öğrenci (Student) hiyerarşisindeki sınıflarda veriler ile ilgili hata kontrollerine gerek yoktur.
2
Bu noktada, istenen işlemlere geçmeden önce, eğitim kurumunun dosya formatının anlaşılması
önem taşımaktadır ve aşağıda bu metin dosyası içeriği örnek üzerinde açıklanmaktadır.

Dosyanın ilk satırında, kaç adet öğretim elemanı derecelendirildiği ile bu öğretim elemanlarına
karşılık gelen harf kodları yer almaktadır. Örneğin, bu dosyada, 5 adet öğretim elemanı
derecelendirilmiş olup, bu öğretim elemanları A, B, C, D ve E harfleri ile kodlanmıştır.
(NOT-1: Bu projede, ayrı bir öğretim elemanı sınıfı yazımı ve harf kodların öğretim elemanı
nesneleri ile eşlenmesi istenmemektedir; arzu ettiğiniz takdirde ileride proje dışı olarak ayrıca bu
eklemeyi kendiniz yapabilirsiniz.)
Örnek dosyanın diğer satırları ise şu şekilde düzenlenmiştir: İlk olarak öğrenci bilgileri yer almakta
(u:lisans öğrencisi (undergraduate), g:lisansüstü öğreci (graduate) anlamında), hemen bir alt
satırında ilgili öğrencinin öğretim elemanları için yaptığı derecelendirmeler bulunmaktadır. Örneğin,
dosyanın 2. ve 3. satırı açıklanacak olursa; 101 numaralı, Ali isimli, Ceviz soyadlı ve izlediği
akademik patika yapay zeka olan lisans öğrencisi A öğretim elemanına 3, B öğretim elemanına 4,
C öğretim elemanına 3, D öğretim elemanına 5 ve E öğretim elemanına 1 puan vermiştir. Benzer
şekilde, diğer öğrencilerin bilgileri ve yaptıkları öğretim elemanı derecelendirmeleri dosya
içeriğinden de görüldüğü gibi benzer şekilde yer almaktadır.
NOT-2: Derecelendirmeler 1 ile 5 arasında yapılmakta olup, 1 puan “çok kötü”, 5 puan ise “çok iyi”
anlamındadır.
NOT-3: Dosyadaki satırlardaki verilerin “virgül” işareti ile ayrıldığı görülmektedir. Verileri dosyadan
elde ederken Java’da hazır olarak bulunan “StringTokenizer” sınıfını veya uygun göreceğiniz başka
bir hazır sınıfı kullanabilirsiniz.
3
Yukarıda tanıtılan dosya okunurken, ilgili öğrenci nesnelerinin oluşturulup “Student” tipinde bir dizi
içinde biriktirilmesi, derecelendirme bilgilerinin ise iki boyutlu bir dizi içine aktarılması
gerekmektedir. Bu iki boyutlu dizide, bir boyutun öğrenciler için, diğer boyutun ise öğretim
elemanları için olduğu düşünülebilecektir ve bu dizinin öğrenci boyutundaki indeksler ile “Student”
tipindeki tek boyutlu dizinin ilgili öğrenci nesnesine ait indeksi uyumludur. Örneğin, tek boyutlu
dizide 3 indeksinde olan öğrencinin verdiği puanlar, iki boyutlu dizide de 3 indeksine karşılık gelen
satırda tutulmuş olmalıdır. Sistemde en fazla 200 adet öğrencinin veri girişi yapabileceğini
düşünebilirsiniz.
NOT-4: Özetle, birisi tek boyutlu, diğeri iki boyutlu iki farklı dizi kullanmanız istenmektedir. Bu proje
için ilk aşamada ArrayList veya başka bir koleksiyon kullanmayınız; belirtilen dizileri tanımlayınız.)
Aşağıda belirtilen işlemleri, dosyayı ilgili dizilere aktardıktan sonra bu dizileri kullanarak yapınız:
1) Her bir öğretim eleman için o öğretim elemanına ait ortalama derecelendirme puanını
hesaplayarak yazdırınız.
2) Her bir öğretim elemanı için sadece lisans öğrencilerini dikkate alarak elde edilen ortalama
derecelendirme puanını hesaplayarak yazdırınız.
3) Her bir öğretim elemanı için sadece lisansüstü öğrencileri dikkate alarak elde edilen ortalama
derecelendirme puanını hesaplayarak yazdırınız.
4) Her bir öğretim elemanı için sadece lisans öğrencilerinden izlediği patika yapay zeka olanlar
dikkate alınarak elde edilen ortalama derecelendirme puanını hesaplayarak yazdırınız.
5) Her bir öğretim elemanı için, o öğretim elemanına ait ortalama derecelendirmenin altında puan
vermiş olan lisans öğrencilerinin bilgilerini yazdırınız.
6) Her bir öğretim elemanı için, o öğretim elemanına ait ortalama derecelendirmenin altında puan
vermiş olan lisansüstü öğrencilerin bilgilerini yazdırınız.
7) Yukarıdaki raporlamalar dışında, programınızda aşağıda belirtilen işlevsellik de olmalıdır, buna
yönelik kodları da ekleyiniz:
Klavyeden girilen belli bir harf veya rakam ile çıkış yapılana veya 200 olarak varsayılan maksimum
öğrenci sayısına ulaşılana dek bir döngü içinde;
4
Klavyeden, ilk önce öğrenci tipi (daha önce söz edildiği gibi “u” veya g”) aldıktan sonra, buna göre
gerekli diğer verileri de alarak ilgili öğrenci nesnesini oluşturup öğrencilerin tutulduğu diziye
ekleyiniz. Daha sonra bu öğrenci için, ilk (derecelendirilecek öğretim elemanı sayısı-1) kadar
öğretim elemanı için (örneğin, 5 öğretim elemanı derecelendiriliyor ise ilk dört öğretim elemanı için)
derecelendirme puanlarını klavyeden alınız. Son öğretim elemanı için olan puanı ise aşağıda
anlatılan yöntemle tahmin ettikten sonra ilgili öğrencinin derecelendirme puanlarını da iki boyutlu
diziye ekleyiniz.
İlk (n-1) adet öğretim elemanı için puanlaması alınan öğrencinin verdiği puanlara en çok benzeyen
öğrencinin bulunabilmesi için aşağıdaki formülü kullanınız (eğer A, B, C, D, E öğretim elemanları
var ise):
Benzerlik Değeri=| Ak – Ad| + | Bk – Bd| + | Ck – Cd| + | Dk – Dd|
Burada, k indeksi ile gösterilen klavyeden girilen değer, d indeksi ile gösterilen ise dosyadaki
(dizideki) bir diğer öğrenciye ait olan değerdir. Bu farkların mutlak değeri alınarak toplanmaktadır.
Düşük bir değer çıkması çok benzerlik var, büyük bir değer çıkması az benzerlik var anlamını
taşımaktadır. Buna göre, klavyeden giriş yapılan öğrencinin girmiş olduğu ilk (n-1) adet puanlama
değerini kullanarak yukarıdaki formül ile bu öğrenciye en çok benzeyen öğrenci(ler) bulunmalı,
hakkında veri girişi yapılmayan son öğretim elemanının puanı benzer öğrenci(ler) dikkate alınarak
(aynı benzerlik değerine sahip birden fazla öğrenci varsa ortalama alınarak, aynı benzerlik
değerinde sadece bir öğrenci varsa da o öğrencinin son öğretim elemanı için verdiği puan baz
alınarak) belirlenmelidir.
8) Klavyeden giriş yapılan öğrencilerin bilgilerini yazdırınız. Daha sonra sadece bu öğrencilerin
puanlamalarını kullanarak her bir öğretim elemanı için ortalama derecelendirme puanını
hesaplayarak yazdırınız.
