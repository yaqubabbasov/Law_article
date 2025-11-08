package com.yaqubabbasov.law_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.yaqubabbasov.law_article.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
   private var _binding: FragmentHomeBinding?=null
    private val binding:FragmentHomeBinding get() = _binding!!
    private var adapter = NewsAdapter()
    private var adapterhorizontal= HorizontalNewsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater, container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageslider()
        search()
        horizontalrecycleview()
        recycleview()


    }
    private fun search (){
        binding.searchBar.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }

    }
    private fun imageslider(){
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel("https://akm-img-a-in.tosshub.com/indiatoday/images/story/202203/WhatsApp_Image_2022-02-25_at_1.jpeg?size=690:388","Russian Troops Attack Ukraine"))
        imagelist.add(SlideModel("https://ichef.bbci.co.uk/news/976/cpsprodpb/12F1/production/_131894840_6adfe195c614392a35b59302768279be708fb03e0_29_2500_14071000x563.jpg.webp","Ukraine war: Zelensky says fortifying front lines must be accelerated"))
        imagelist.add(SlideModel("https://ichef.bbci.co.uk/news/976/cpsprodpb/10F87/production/_131511596_capture.png.webp","Ukraine war: Avdiivka civilians cling on amid Russian assault"))
        binding.imageslider.setImageList(imagelist,ScaleTypes.CENTER_INSIDE)
    }
    private fun recycleview(){
        binding.rv.layoutManager=LinearLayoutManager(requireContext())
        binding.rv.adapter= adapter
        val list = ArrayList<Newsdata>()
        val d1 = Newsdata(R.drawable.russianwar1,"BMT Komissiyası Ukraynada  dinc əhalinin əziyyət çəkməsindən narahatlığını ifadə edib","CENEVRE, 23 sentyabr 2022-ci il - Kiyev, Çerniqov, Xarkov və Sumi bölgələrində baş verən hadisələrlə bağlı araşdırmalarına əsasən, Ukrayna üzrə Müstəqil Beynəlxalq Araşdırma Komissiyası Ukraynada hərbi cinayətlərin törədildiyi qənaətinə gəlib.\n" +
                "\n" +
                "Komissiya partlayıcı silahlardan qeyri-qanuni istifadə, ayrıseçkilik etmədən hücumlar, şəxsi toxunulmazlığın pozulması, o cümlədən edamlar, işgəncə və pis rəftar, cinsi və gender əsaslı zorakılıq kimi pozuntuları sənədləşdirib. Həmçinin uşaqların hüquqlarının pozulduğu aşkarlanıb.\n" +
                "\n" +
                "2022-ci ilin iyununda Ukraynaya səfəri zamanı Komissiya geniş ərazi təsirinə malik partlayıcı silahların yaşayış binalarına və əhalinin məskunlaşdığı ərazilərdə, o cümlədən məktəblər və xəstəxanalardakı infrastruktura vurduğu zərəri öz gözləri ilə müşahidə edib. Komissiyanın araşdırdığı bir sıra hücumlar mülki şəxslərlə döyüşçülər arasında fərq qoyulmadan həyata keçirilib.\n" +
                "\n" +
                "Komissiyanın sədri Erik Mose, \"Gəzdiyimiz ərazilərdə çoxlu sayda edam edilməsi bizi heyrətə gətirdi\" dedi. “Ukraynadakı beynəlxalq silahlı münaqişənin mülki əhaliyə verdiyi iztirablardan narahatıq”.\n" +
                "\n" +
                "O, əlavə edib ki, Komissiya hazırda 16 şəhər və qəsəbədə edamlarla bağlı araşdırma aparır və daha bir çox belə hallarla bağlı mötəbər iddialar alıb. Bu cinayətlərin ümumi elementlərinə qurbanların qabaqcadan həbsi və gözə çarpan edam əlamətləri, məsələn əllərin arxadan bağlanması, başından güllə yarası və boğazın kəsilməsi daxildir.\n" +
                "\n" +
                "Şahidlər Komissiyaya qeyri-qanuni həbs zamanı həyata keçirilən pis rəftar və işgəncələr barədə ardıcıl hesabatlar təqdim ediblər. Zərərçəkmişlərdən bəziləri Ukraynada Rusiya qüvvələri tərəfindən ilkin saxlandıqdan sonra Rusiya Federasiyasına köçürüldüklərini və həftələrlə təcridxanalarda saxlandıqlarını, burada işgəncələrə və digər pis rəftara məruz qaldıqlarını bildirdilər.\n" +
                "\n" +
                "Seksual və gender əsaslı zorakılıqla bağlı aparılan araşdırma göstərdi ki, Rusiya Federasiyasının bəzi əsgərləri belə cinayətlər törədiblər. Cinsi və gender əsaslı zorakılıq qurbanlarının yaşı 4 ilə 82 arasında dəyişirdi.\n" +
                "Komissiya həmçinin müəyyən edib ki, uşaqlar təkrar partlayışlara, qanun pozuntularına, məcburi köçkünlərə və ailə üzvlərindən ayrılmağa, habelə digər pozuntulara məruz qalıblar.\n" +
                "İstintaqın aparıldığı dörd ərazidə - Kiyev, Çerniqov, Xarkov və Sumıda Komissiya Ukrayna qüvvələri tərəfindən Rusiya Federasiyası əsgərlərinə qarşı pis rəftarla bağlı iki hadisəni araşdırıb. Sayları az olsa da, belə hallar Komissiyanın diqqət mərkəzində olmaqda davam edir.")
        val d2 = Newsdata(R.drawable.russianwar2,"BMT Rusiyanın Ukraynadakı müharibə cinayətlərinə dair əlavə sübutlar tapıb","Birləşmiş Millətlər Təşkilatının təhqiqatı Rusiya qüvvələrinin Ukraynada zorlama və uşaqların Rusiyaya deportasiyası da daxil olmaqla “ayrıseçkilik etmədən hücumlar” və müharibə cinayətləri törətdiyinə dair əlavə sübutlar tapıb.\n" +
                "Birləşmiş Millətlər Təşkilatının Ukrayna üzrə Təhqiqat Komissiyasının təqdim etdiyi hesabatda deyilir: “Toplanan sübutlar daha da göstərir ki, Rusiya hakimiyyəti qəsdən öldürmə, işgəncə, zorlama və digər cinsi zorakılıq və uşaqların Rusiya Federasiyasına deportasiyası kimi hərbi cinayətlər törədib”. BMT Baş Assambleyasına.\n" +
                "\n" +
                "“Komissiya bu yaxınlarda yaşayış binaları, dəmir yolu stansiyası, mağazalar və mülki istifadə üçün anbar kimi mülki obyektlərə təsir edən və çoxsaylı insan tələfatına səbəb olan hücumları sənədləşdirib”.\n" +
                "Rusiya dəfələrlə mülki əhalinin hədəf alındığını təkzib edib və Ukraynanın müharibə cinayətləri ilə bağlı iddialarının uydurulduğunu bildirib.\n" +
                "Komissiya bildirib ki, o, son araşdırmalarını Xerson və Zaporojjya əyalətlərində cəmləyib və “Rusiya hakimiyyətinin Xerson vilayətinin bir rayonunda zorlama və cinsi zorakılıq törətdiyinə dair sübutlar” tapıb.\n" +
                "\n" +
                "Komissiya Rusiya hakimiyyət orqanları tərəfindən müşayiət olunmayan uşaqların Rusiya Federasiyasına və ya Ukraynada işğal etdikləri ərazilərə köçürülməsi ilə bağlı əlavə məlumatları araşdırıb. O, xüsusilə 2022-ci ilin mayında Ukraynadan Rusiya Federasiyasına 31 uşağın köçürülməsini sənədləşdirib və bunun qeyri-qanuni deportasiya və müharibə cinayəti olduğu qənaətinə gəlib.\n" +
                "Bu mart ayında Haaqa Beynəlxalq Cinayət Məhkəməsi (ICC) ukraynalı uşaqların oğurlanmasına nəzarət etdiyinə görə Vladimir Putinin həbsinə order verib.\n" +
                "Bu arada prezident Vladimir Zelenski yüksək səviyyəli komandirlərlə birlikdə cənubdakı Xerson bölgəsinə səfər edib və burada Rusiyanın hücumlarını intensivləşdirdiyi iki yer olan Avdiivka və Kupyanskı müdafiə etdikləri üçün Ukrayna qoşunlarını tərifləyiblər.\n" +
                "\n" +
                "Telegram mesajlaşma proqramında yayımlanan videoda Zelenski deyib: “Müdafiəni güclü şəkildə saxlayan və işğalçını günü-gündən məhv edən bütün oğlanlarımıza təşəkkür edirəm”.\n" +
                "“Bu günlərdə Rusiyanın itkiləri həqiqətən heyrətləndiricidir və Ukraynaya məhz işğalçının itkiləri lazımdır”.\n" +
                "\n" +
                "Bu ay Rusiya Ukraynanın şərqindəki Avdiivka şəhərinə qəfil hücuma başlayıb və bunun Moskva qüvvələrinin ciddi itkiləri ilə nəticələndiyi bildirilir.\n" +
                "İlkin olaraq bir qədər yer tutduqdan sonra, Ukrayna əks batareya atəşi ilə cavab verərkən rus qoşunları özlərini tez yerə yıxıblar.\n" +
                "Ukraynanın şərqindəki Donetsk şəhərinin ətrafı olan Avdiivka 2014-cü ildə Rusiyanın ilk hərbi müdaxiləsindən bəri cəbhə xəttindədir.\n" +
                "\n" +
                "“Oktyabrın 10-da Rusiyanın Avdiivka bölgəsindəki ilkin hücum əməliyyatları da yüksək təsdiqlənmiş Rusiya texnikası itkiləri ilə nəticələndi”, – Vaşinqtonda yerləşən Müharibənin Öyrənilməsi İnstitutu, müntəzəm olaraq münaqişənin təhlilini dərc edən X-də yazır. əvvəllər Twitter kimi tanınan platforma.\n" +
                "“Rusiya qüvvələrinin ilkin hücumlardan sonra yenidən qruplaşması və hücumlara yenidən başlaması onu göstərir ki, ya Rusiya qüvvələri Avdiivkanı ələ keçirə biləcəklərinə inanır, ya da Rusiya hərbi komandanlığı dəyərindən asılı olmayaraq hücum əməliyyatlarına zəif prioritet verir”, - deyə analitik mərkəzi əlavə edib.")
        val d3 = Newsdata(R.drawable.russianwar3,"Müharibə cinayəti nədir və Putin Ukraynaya görə mühakimə oluna bilərmi?","Müharibə cinayəti nədir və BCM nədir?\n" +
                "\n" +
                "Müharibə qaydaları Cenevrə Konvensiyalarında və digər beynəlxalq qanun və sazişlərdə öz əksini tapıb.\n" +
                "Bir qrupun qətli, zorlanması və ya kütləvi təqibi kimi ağır cinayətlər “insanlığa qarşı cinayətlər” və ya bəzi hallarda “soyqırım” kimi tanınır.\n" +
                "Hərbi qüvvələr qəsdən mülki şəxslərə - nə də onların asılı olduğu infrastruktura, məsələn, elektrik stansiyalarına hücum edə bilməz.\n" +
                "Bəzi silahlar, məsələn, piyada əleyhinə minalar, kimyəvi və ya bioloji silahlar qadağandır.\n" +
                "Xəstə və yaralılara, o cümlədən hərbi əsir kimi hüquqları olan yaralı əsgərlərə qulluq edilməlidir.\n" +
                "Haaqada yerləşən BCM hərbi cinayətləri və insanlığa qarşı cinayətləri araşdırmaq üçün yaradılıb.\n" +
                "O, tez-tez məhkəmə sistemi zəif olan və bu cür işləri öz məhkəmələrində mühakimə edə bilməyən ölkələrin adından məhkəmələr keçirir.\n" +
                "Prezident Putinə qarşı hansı ittihamlar var?\n" +
                "BMT-nin Ukrayna üzrə Təhqiqat Komissiyası Rusiya hakimiyyətinin Ukraynadan 16 221 uşağı Rusiyaya apardığını bildirib.\n" +
                "BMT həmçinin bildirib ki, Ukraynadakı Rusiya qüvvələri zorlamalar, \"geniş yayılmış\" işgəncələr və qətllərə görə məsuliyyət daşıyır:\n" +
                "Mart 2022: Rusiya qüvvələri Mariupolda uşaqlara sığınan teatra hava zərbəsi endirib və şəhərdəki xəstəxanaya hücum edib.\n" +
                "Aprel 2022: Kiyev yaxınlığındakı Buçada 400 mülki şəxsin cəsədi tapıldı\n" +
                "Sentyabr 2022: Xarkov vilayətinin İzium şəhərində 450 cəsəd tapıldı - əksəriyyəti mülki şəxslər\n" +
                "Ukrayna həmçinin Rusiya qüvvələrini 2022-ci ilin mart-noyabr ayları arasında Xerson vilayətində 400-dən çox hərbi cinayət törətməkdə ittiham edib.\n" +
                "Bundan əlavə, BMT bildirir ki, Rusiya elektrik stansiyaları və bəndlər kimi mülki infrastruktura hücum edərək “insanlığa qarşı cinayətlərə” görə məsuliyyət daşıya bilər.\n" +
                "Rusiya hərbi cinayətlər və mülki əhalini hədəf alan bütün iddiaları rədd edib.\n" +
                "\n" +
                "Rusiya Ukraynaya görə hərbi cinayətlərin araşdırılması ilə üz-üzədir\n" +
                "Cənubi Afrika necə iştirak edir?\n" +
                "Prezident Putin Bric ölkələrinin (Braziliya, Rusiya, Hindistan, Çin və Cənubi Afrika) konfransında iştirak etmək üçün avqustda ölkəyə səfər etməli idi.\n" +
                "\n" +
                "Cənubi Afrikanın əsas müxalifət partiyası Demokratik Alyans məhkəmələrdən onun gələcəyi təqdirdə həbs olunmasına qərar verməsini xahiş edib.\n" +
                "Lakin məhkəməyə təqdim olunan sənədlərdə prezident Ramafosa bunun baş verməməli olduğunu bildirib: “Rusiya açıq şəkildə bildirdi ki, öz hazırkı prezidentinin həbsi müharibə elanı olacaq”.\n" +
                "Daha sonra o, prezident Putinlə onun gəlməməsi barədə “qarşılıqlı olaraq” razılaşdıqlarını söylədi. Onun yerinə Rusiyanın xarici işlər naziri Sergey Lavrov iştirak edəcək.\n" +
                "Cənubi Afrika daha əvvəl BCM-yə məhəl qoymayıb.\n" +
                "2015-ci ildə o, Sudanın o zamankı prezidenti Ömər əl-Bəşiri həbs etməkdən və Cənubi Afrika aviabazasından uçmağa icazə verməkdən imtina edib.\n" +
                "BCM onu Darfur bölgəsindəki münaqişə ilə bağlı soyqırım və müharibə cinayətlərində ittiham etmişdi.\n" +
                "\n" +
                "BCM Putini mühakimə edə bilərmi?\n" +
                "ICC əsassız işğal və ya özünümüdafiə üçün həyata keçirilməyən münaqişə vəziyyətində siyasi liderlərə qarşı \"aqressiv müharibə aparmağa\" görə ittiham irəli sürə bilər.\n" +
                "O, Rusiya Krımı qanunsuz ilhaq etməzdən əvvəl, 2013-cü ilə qədər Ukraynada həyata keçirilən potensial hərbi cinayətləri və insanlığa qarşı cinayətləri araşdırıb.\n" +
                "2023-cü ilin martında o, prezident Putinə və Rusiyanın Uşaq Hüquqları üzrə Müvəkkili xanım Mariya Lvova-Belovaya qarşı həbs qərarı çıxarıb.\n" +
                "Bununla belə, Rusiya BCM-i imzalayan ölkə deyil, ona görə də Putin və ya xanım Lvova-Belovanı ekstradisiya etmək ehtimalı çox azdır.\n" +
                "Prezidentin onu həbs edə biləcək hər hansı ölkəyə getməsi gözlənilmir.")
        val d4 = Newsdata(R.drawable.backedinvest,"BMT-nin dəstəklədiyi təhqiqat Rusiyanın Ukraynadakı hərbi cinayətlərinə dair sübutlar tapıb","CENEVRE (AP) - BMT-nin dəstəklədiyi araşdırmanın cümə axşamı açıqladığı hesabata görə, Rusiyanın Ukraynada mülki şəxslərə qarşı hücumları, o cümlədən işğal olunmuş bölgələrdə sistematik işgəncə və qətllər, müharibə cinayətləri və ola bilsin ki, insanlıq əleyhinə cinayətlərə bərabərdir.\n" +
                "\n" +
                "Rusiyanın Mariupoldakı bir teatra hücumu nəticəsində içəridə sığınan yüzlərlə insanın həlak olmasından bir il sonra yayımlanan geniş insan haqları hesabatı BMT Təhlükəsizlik Şurasının üzvünə qarşı olduqca qeyri-adi bir qınama oldu.Hesabatda insanlığa qarşı potensial cinayətlər arasında payızdan bəri Ukrayna infrastrukturunu hədəf alan və ən soyuq aylarda yüz minlərlə insanın istilik və işıqsız qalmasına səbəb olan təkrar hücumlar, eləcə də Rusiyanın işğalı altında olan bir çox regionlarda “sistemli və geniş yayılmış” işgəncələr göstərilir.\n" +
                "\n" +
                "Təhqiqat komissiyası BMT-nin dəstəklədiyi İnsan Haqları Şurasının bütün dünyada sui-istifadə və pozuntuları yoxlamaq üçün istifadə etdiyi ən güclü vasitədir. Cümə axşamı açıqlanan təhqiqat Rusiyanın keçən il işğalından qısa müddət sonra təcili müzakirələr zamanı yaradılıb.\n" +
                "\n" +
                "Komissiyanın üç üzvü insan hüquqları üzrə müstəqil ekspertlərdir və onun əməkdaşları şuradan və BMT-nin insan hüquqları bürosundan dəstək və maliyyə alır.\n" +
                "\n" +
                "Hesabatın müəllifləri Ukrayna qüvvələri tərəfindən \"az sayda\" aşkar pozuntuları, o cümlədən Ukrayna hakimiyyəti tərəfindən cinayət təhqiqatının aparıldığını qeyd ediblər, lakin hesabatlarının böyük əksəriyyətini Rusiyaya qarşı ittihamlar üçün saxlayıblar.\n" +
                "Rusiya sorğunun məlumat üçün müraciətlərinə cavab verməyib.\n" +
                "\n" +
                "İstintaq tərəfindən vurğulanan sui-istifadə hallarının əksəriyyəti artıq məlum idi, lakin tapıntılar beynəlxalq ictimaiyyətin imtiyazı ilə gəlir: Ekspertlər keçən il BMT-nin 47 üzvünün hökumətlərini birləşdirən İnsan Hüquqları Şurası tərəfindən yaradılmış mandat altında işləyirlər. ölkələr.\n" +
                "\n" +
                "Nəhayət, hesabat müharibədə törədilmiş cinayətlərə görə məsuliyyəti artırmaq səylərini əlavə edə bilər – istər Beynəlxalq Cinayət Məhkəməsi, istərsə də vəhşiliklərin harada baş verməsindən asılı olmayaraq, “ümumdünya yurisdiksiyasını” təqib etmək hüququnu öz üzərinə götürmüş bəzi ayrı-ayrı ölkələr tərəfindən .")
        val d5= Newsdata(R.drawable.fhn,"Ekspertlər Rusiyanın Ukraynaya müdaxiləsinə görə müharibə cinayətlərdə ittiham oluna biləcəyini düşünürlər","Çərşənbə günü UCLA Hüquq Məktəbində keçirilən müzakirədə iki UCLA alimi və beynəlxalq hüquqşünas Rusiyanın Ukraynadakı hərəkətlərinə görə hərbi cinayətlərdə ittiham oluna biləcəyinə cavab axtarıblar.\n" +
                "\n" +
                "\n" +
                "Panel iştirakçıları qəti bir nəticəyə gəlməyiblər. Lakin onlar müharibə cinayətləri təqibinin hazırkı vəziyyətini izah etməyə kömək edən bir sıra mövzuları əhatə edirdilər, həmçinin günahkarların gələcəkdə ədalətə cəlb edilməsinə nə kömək edə bilər.\n" +
                "\n" +
                "\n" +
                "Ölənlərin sayının on minlərlə olduğu təxmin edilən Ukraynanın hər yerində çoxsaylı hərbi cinayətlər qeydə alınıb. Lakin tədbirin moderatoru, UCLA Burkle Beynəlxalq Münasibətlər Mərkəzinin direktor müavini Alexandra Lieben bildirib ki, son münaqişə yalnız Vladimir Putin dövründə faciəvi tarixi genişləndirir, o cümlədən 1999-cu ildə ikinci Çeçen müharibəsi, 2014-cü ildə Rusiyanın Krımı ələ keçirməsi və onun ordusu da daxil olmaqla. 2015-ci ildə Suriyaya müdaxilə.\n" +
                "\n" +
                "\n" +
                "\"Beləliklə, eyni nümunənin yenidən ortaya çıxdığını gördük\" dedi Lieben. “Bu dönüş nöqtəsi ola bilərmi? Rusiya komandirləri və bəlkə də prezident Putinin özü Ukraynadakı münaqişədə baş verənlərə, məhbuslara və ya zorla Rusiyaya köçürülən insanlara görə cavabdeh ola bilərmi?”\n" +
                "\n" +
                "\n" +
                "Panel iştirakçıları UCLA politologiya professoru Daniel Treisman idi; Jessica Peake, hüquq məktəbinin beynəlxalq və müqayisəli hüquq proqramının direktoru; və Londondan videokonfrans vasitəsilə beynəlxalq cinayət hüququ, insan hüquqları və sanksiyalar üzrə ixtisaslaşmış hüquq məsləhətçisi Alexandre Prezanti. İnternetdə də yayımlanan tədbir Burkle Mərkəzi, UCLA Promise Beynəlxalq İnsan Hüquqları İnstitutu və UCLA Avropa və Rusiya Araşdırmaları Mərkəzi tərəfindən birgə maliyyələşdirilib.\n" +
                "\n" +
                "\n" +
                "\"Müharibənin ilk günlərindən biz müharibə cinayətlərinin olduqca dəhşətli sübutlarının şahidi oluruq\" dedi Treisman. “Məktəblərdə, xəstəxanalarda, ticarət mərkəzlərində mülki şəxslərin qəsdən bombalanması var – açıq-aşkar vəhşiliklər yuxarı məmurların əmri ilə həyata keçirilir. Və daha sonra mülki insanlara qarşı yer səviyyəsində işgəncə, zorlama və qətllər var.”\n" +
                "\n" +
                "\n" +
                "Treysman, Rusiya silahlı qüvvələrinin bu cür cinayətlərinin keçmişdə nadir hallarda cəzalandırıldığını, hətta \"hətta etiraf edildiyini\" söylədi. “Sual ondan ibarətdir ki, bu gün Ukraynada [o müharibə cinayətləri] daha sistemli şəkildə araşdırılacaq, qeydə alınacaq və mühakimə olunacaq”.\n" +
                "\n" +
                "\n" +
                "Treysmanın sözlərinə görə, Ukraynanın əvvəlki Rusiya münaqişələrindən fərqli cəhəti indiki müharibənin “tamamilə səbəbsiz” olmasıdır. Bu hərəkətlər zamanı Çeçenistanda təhlükəsizlik problemləri və Suriyada vətəndaş müharibəsi olduğu halda, Ukrayna heç kim üçün təhlükə yaratmırdı.\n" +
                "\n" +
                "\n" +
                "Peake bildirib ki, Rusiyanın hadisəni “xüsusi hərbi əməliyyat” kimi səciyyələndirməsinə baxmayaraq, işğal açıq şəkildə beynəlxalq silahlı münaqişədir, bu da “müharibə cinayətlərinin” beynəlxalq hüquqi tərifinin sözsüz ki, oyunda olduğunu göstərir.\n" +
                "\n" +
                "\n" +
                "O, BMT İnsan Haqları Şurasının Ukrayna üzrə Müstəqil Beynəlxalq Təhqiqat Komissiyasının müharibənin ilk iki ayı ərzində çoxsaylı hərbi cinayətləri və insan haqları pozuntularını sənədləşdirən hesabatına istinad edib.\n" +
                "\n" +
                "\n" +
                "\"Onlar çoxlu mülki vətəndaşı öldürən və yaralayan və bütün məhəllələri dağıdan partlayıcı silahlardan amansız istifadə tapdılar\" dedi. “Komissiya həmçinin Rusiya silahlı qüvvələri tərəfindən işğal olunmuş ərazilərdə qısamüddətli edamlar, qeyri-qanuni həbs, işgəncə, pis rəftar, zorlama və digər cinsi zorakılıq hallarını sənədləşdirib”.\n" +
                "\n" +
                "\n" +
                "Rusiya və onun ordusunu müharibə cinayətlərinə görə məsuliyyətə cəlb etmək səylərinə Beynəlxalq Cinayət Məhkəməsində və ya ICC-də araşdırma və Ukraynada daxili təqiblər daxildir.\n" +
                "\n" +
                "\n" +
                "Lakin Peake, ICC prosesinin çox uzun vaxt aparacağını və ən yaxşı halda yalnız bir neçə yüksək səviyyəli günahkarın mühakimə olunmasına səbəb ola biləcəyini söylədi. Ukrayna daxilində müharibə cinayətlərinə mühakimə etmək yanaşması da çətin olur: Xarici vətəndaşlara qarşı cinayətlərə mühakimə etmək çoxlu beynəlxalq yardım olmadan olduqca çətindir, Pik deyib.\n" +
                "\n" +
                "\n" +
                "Prezanti deyib ki, Rusiyaya qarşı müharibə cinayətləri ittihamı irəli sürmək üçün dünya ictimaiyyətindən “görünməmiş” dəstək var. “Beynəlxalq hüquqşünaslar sözün əsl mənasında özlərini vəziyyətə atırlar” dedi.\n" +
                "\n" +
                "\n" +
                "Lakin o, rus aktyorlarının məsuliyyətə cəlb edilməsində böyük maneələrin olduğunu da etiraf etdi. Birincisi, cinayətkarların çoxu Ukraynada, ölü və ya geri dönmüş Rusiyada döyüşür, Prezantinin sözlərinə görə, xaricdə ədalətlə üzləşmək üçün ekstradisiya olunmaqdan qorunurlar.")

        list.add(d1)
        list.add(d2)
        list.add(d3)
        list.add(d4)
        list.add(d5)

        adapter.updatelist(list)
    }
    private fun horizontalrecycleview(){
        binding.rvhorizontal.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvhorizontal.adapter=adapterhorizontal
        val horizlist= ArrayList<Newsdata>()
        val d1= Newsdata(R.drawable.putin,"Rusiyaya bağlı 4 hərbi qulluqçu Rusiyanın Ukraynaya müdaxiləsi ilə əlaqədar müharibə cinayətlərdə ittiham olunur","Bu gün Virciniya ştatının Şərq Bölgəsində Rusiyaya bağlı 4 hərbçiyə qarşı müharibə cinayətləri ittihamı açıqlanıb. İttihamlara işgəncə, qeyri-insani rəftar və Rusiyanın 2022-ci ilin fevralında Ukraynaya genişmiqyaslı müdaxiləsindən sonra ABŞ vətəndaşının Ukraynada qanunsuz həbsi daxildir.\n" +
                "\n" +
                "45 yaşlı Suren Seiranoviç Mkrtçyan, Dmitri Budnik, Valerii LNU (soyadı məlum deyil) və Nazar LNU hər biri Rusiya və Ukrayna arasında silahlı münaqişə kontekstində ABŞ vətəndaşının qanunsuz həbsi ilə bağlı ittiham edilib. İddia olunur ki, təqsirləndirilən şəxslər zərərçəkmişi dindiriblər, ağır döyüblər və işgəncə veriblər. Onlar həmçinin qurbanı öldürməklə hədələyib və saxta edam ediblər.\n" +
                "\n" +
                "“Dünya Rusiyanın Ukraynaya qəddarcasına işğalının dəhşətlərinin şahidi olduğu kimi, Birləşmiş Ştatların Ədliyyə Departamenti də belədir”, - Baş prokuror Merrik B. Qarland bildirib. “Məhz buna görə də Ədliyyə Departamenti Amerika vətəndaşına qarşı ağır cinayətlər törətməkdə Rusiyaya bağlı dörd hərbi qulluqçuya qarşı ABŞ-ın hərbi cinayətlər qanununa əsasən ilk ittihamları irəli sürüb. Ədliyyə Departamenti Rusiyanın işğalçı müharibəsinə görə məsuliyyət və ədaləti təmin etmək üçün lazım olan müddət ərzində çalışacaq.”\n" +
                "\n" +
                "“Milli Təhlükəsizlik Təhqiqatları və Ədliyyə Departamentinin federal hüquq-mühafizə orqanlarının yorulmaz və görünməmiş işi sayəsində Amerika vətəndaşına qarşı ağlasığmaz, qəbuledilməz insan hüquqları pozuntularında ittiham olunan dörd rus əsgəri müharibə cinayətlərində ittiham olunub və məhkəməyə gətiriləcək. ədalət”, – deyə Daxili Təhlükəsizlik katibi Alejandro N. Mayorkas bildirib. \"Bu gün möhürlənmiş ittihamnamələr Rusiyaya açıq mesaj verir - hökumətimiz amerikalıların fundamental insan hüquqlarını pozanları məsuliyyətə cəlb etmək üçün səylərini əsirgəməyəcək və heç bir resursunu əsirgəməyəcək.\"\n" +
                "\n" +
                "FTB direktoru Kristofer Wray deyib: “Ukraynaya səbəbsiz işğalı başlayandan bəri Rusiya ağlasığmaz faciəyə səbəb olmaq üçün insan haqları pozuntularını silahlandırıb”. “Bugünkü ittiham aktı – ABŞ-ın müharibə cinayətləri qanununa əsasən ilk dəfədir – FTB-nin bu vəhşiliklərin qurbanlarına ədalət gətirmək üçün beynəlxalq hüquq-mühafizə orqanlarının tam əməkdaşlığı ilə çalışacağını açıq şəkildə göstərir. Ukraynadakı münaqişənin insan tələfatı FTB-nin ürəyinə çox ağır gəlir və biz hərbi cinayətkarları harada olmalarından və nə qədər vaxt aparmasından asılı olmayaraq məsuliyyətə cəlb etməyə qərarlıyıq”.\n" +
                "\n" +
                "Ədliyyə Departamentinin Cinayət Şöbəsinin Baş Prokurorunun köməkçisi vəzifəsini icra edən Nikol M. Argentieri deyib: “Müdafiə olunan şəxsə işgəncə vermək və qanunsuz həbs etmək cəzasız qalmamalı olan ciddi insan hüquqları pozuntularıdır”. “Bu tarixi cinayət ittihamları – ABŞ-ın hərbi cinayətlər qanunu çərçivəsində ilk dəfə irəli sürülən ittihamlar – Ədliyyə Nazirliyinin Ukraynada müharibə cinayətləri və digər vəhşiliklər törədənlər üçün hər cür məsuliyyətə cəlb olunması istiqamətində davam edən səylərində mühüm addımdır”.\n" +
                "\n" +
                "İttihamnamədəki iddialara görə, Mkrtçyan və Budnik Rusiya Silahlı Qüvvələrinin və/və ya qondarma Donetsk Xalq Respublikasının hərbi hissələrinin komandirləri, Valerii və Nazar isə aşağı rütbəli hərbçilər olub. Müttəhimlərin Ukraynada hərbi cinayətlər törətdikləri zaman Rusiya adından döyüşdükləri iddia edilir.")
        val d2 = Newsdata(R.drawable.animaamerica,"ABŞ Rusiya-Ukrayna müharibəsi ilə bağlı ilk müharibə cinayətləri ittihamını irəli sürüb","Çərşənbə günü ölkənin yüksək səviyyəli hüquq-mühafizə orqanları Ukrayna müharibəsində bir amerikalıya işgəncə verməkdə günahlandırılan dörd rus əsgərinə qarşı müharibə cinayətləri ittihamlarını elan etdilər - dedilər ki, ABŞ ilk dəfədir ki, təxminən 30 il əvvəl qəbul edilmiş müharibə cinayətləri qanununa əsaslanan ittiham aktı təqdim edir. The charges unsealed Wednesday in federal court in Virginia include torture, mistreatment, and unlawful confinement of an American citizen who was living in Ukraine following the Russian invasion of its neighbor in 2022.\n" +
                "\n" +
                "The four people charged — Suren Seiranovich Mkrtchyan, 45, Dmitry Budnik, and two others whose full names are not yet known — allegedly interrogated, tortured and threatened to kill the victim, even holding a mock execution. The alleged torment occurred over the course of 10 days in April 2022. All four men remain at large, and the chances of them being captured or turned over to U.S. authorities are low.")
        val d3 = Newsdata(R.drawable.americaukra,"ABŞ Ukrayna işğalında amerikalıya işgəncə verməkdə ittiham olunan ruslara qarşı müharibə cinayəti ittihamı irəli sürüb","WASHINGTON (AP) - Ukraynanın işğalı zamanı bir amerikalıya işgəncə verməkdə təqsirləndirilən dörd rusiyalı kişi ilk dəfə olaraq hərbi cinayətlərdə ittiham olunub, Ədliyyə Departamenti çərşənbə günü elan edib.\n" +
                "\n" +
                "Bu, Moskvanın Ukraynaya qarşı müharibəsi zamanı vəhşiliklərlə bağlı Rusiya silahlı qüvvələrinin üzvlərinə qarşı ilk mühakimədir və Ədliyyə Departamenti ilk dəfədir ki, təqribən 30 illik qanuna əsasən, cinayət məsuliyyətinə cəlb etməyi cinayət hesab edir. Müharibə zamanı işgəncə və ya qeyri-insani rəftara görə Amerika.\n" +
                "\n" +
                "Departamentin fərari olan dörd müttəhimdən hər hansı birini həbsə gətirməsinin mümkünsüz perspektivlərini nəzərə alsaq, ittihamlar hələlik böyük ölçüdə simvolik xarakter daşıyır. Lakin ABŞ rəsmiləri bu hadisəni Rusiyanın hərbi cinayətləri ilə bağlı araşdırmalarında tarix yaradan bir məqam kimi qiymətləndiriblər. Daha çox ittihamlar gələ bilər.Amerikanın daxili təhlükəsizlik katibi Alejandro Mayorkas bildirib ki, amerikalı ötən il istintaq çərçivəsində Ukraynaya səfər etmiş federal agentlərə rus əsgərlərinin onu qaçırdığını, lüt soyundurduğunu, başına silah dayayıb və çox pis döydüyünü bildirib.\n" +
                "\n" +
                "Çərşənbə günü Virciniya ştatının Şərq Bölgəsində möhürlənməmiş beş maddəlik ittiham aktına görə, o, həmçinin sərt sorğu-sual üsullarına məruz qalıb, cinsi təcavüzlə hədələnib və özünün saxta edamında iştirak etməyə məcbur edilib.\n" +
                "\n" +
                "\"Agentlərimizin topladığı sübutlar Rusiyanın işğalının qəddarlığı, cinayətkarlığı və pozğunluğundan danışır\" dedi Mayorkas.\n" +
                "\n" +
                "Mayorkas bildirib ki, Daxili Təhlükəsizlik və FTB müstəntiqləri oğurluq zamanı Mylove kəndinin ətrafında olan amerikalı, onun ailəsi və digər şəxslərdən dörd rusun kimliyini müəyyən etmək üçün sorğu keçiriblər.\n" +
                "\n" +
                "\"Bu kimi işlər FTB-nin işlədiyi ən mürəkkəb işlərdən biridir, lakin onların gətirilməsi bu kimi cinayətlərin qarşısını almaq və günahkar ola biləcək şəxslərə heç kimin qanundan üstün olmadığını və müharibə cinayətlərinin cəzasız qalmayacağını göstərmək üçün vacibdir\" dedi FTB direktoru Kristofer Wray dedi.")
        horizlist.add(d1)
        horizlist.add(d2)
        horizlist.add(d3)
        adapterhorizontal.updatelist(horizlist)




    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}