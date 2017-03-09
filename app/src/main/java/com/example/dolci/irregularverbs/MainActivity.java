package com.example.dolci.irregularverbs;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    Adapter adapter;
    MediaPlayer sound;
   // SoundPool soundPool;
    boolean flag=false;

    String[] firstForms={"be","become","begin","break","bring","build","buy","catch","choose","come","cost","cut","do","draw",
    "dream","drink","drive","eat","fall","fell","find","fly","get","give","go","grow","have","hear","hit","hold",
    "hurt","keep","know","learn","leave","lend","lose","make","mean","meet","pay","put","read","ride","ring","run",
    "say","see","sell","send","show","shut","sing","sit","sleep","speak","spend","stand","steal","swim","take","teach",
            "tell","think","throw","wake","wear","understand","win","write","awake","beat","bite","bleed","blow","burn",
            "dig","feed","fight","fit","forget","forgive","freeze","hang","hide","let","lie","light","quit","rise","shake"
            ,"shine","shoot","sink","stick","strike","tear","bear","bend","breed","cast","deal","forbid","kneel","knit","lead",
            "seek","set","shrink","slide","split","spread","swear","sweep","swing","arise","bet","flee","lay","spin","stink",
            "bind","cling","creep","fling","forsake","foretell","grind","leap","saw","shed","slay","sling","spring","sting",
            "strive","tread","weep","wind","wring"};

    String[] secondForms={"was/were","became","began","broke","brought","built","bought","caught","chose",
    "came","cost","cut","did","drew","dreamt","drank","drove","ate","fell","felt","found","flew","got","gave","went",
            "grew","had","heard","hit","held","hurt","kept","knew","learnt","left","lent","lost","made","meant","met",
            "paid","put","read","rode","rang","ran","said","saw","sold","sent","showed","shut","sang","sat","slept"
            ,"spoke","spent","stood","stole","swam","took","taught","told","thought","threw","woke","wore","understood",
            "won","wrote","awoke","beat","bit","bled","blew","burnt","dug","fed","fought","fit","forgot","forgave","froze",
            "hung","hid","let","lay","lit","quit","rose","shook","shone","shot","sank","stuck","struck","tore","bore",
            "bent","bred","cast","dealt","forbade","knelt","knit","led","sought","set","shrank","slid","split","spread",
            "swore","swept","swung","arose","bet","fled","laid","spun","stank","bound","clung","crept","flung","forsook",
            "foretold","ground","leapt","sawed","shed","slew","slung","sprang","stung","strove","trod","wept","wound","wrung"};

    String[] thirdForms={"been","become","begun","broken","brought","built","bought","caught","chosen","come","cost",
    "cut","done","drawn","dreamt","drunk","driven","eaten","fallen","felt","found","flown","got","given","gone","grown",
            "had","heard","hit","held","hurt","kept","known","learnt","left","lent","lost","made","meant","met","paid","put",
            "read","ridden","rung","run","said","seen","sold","sent","shown","shut","sung","sat","slept","spoken","spent","stood",
            "stolen","swum","taken","taught","told","thought","thrown","woken","worn","understood","won","written","awoken",
            "beaten","bitten","bled","blown","burnt","dug","fed","fought","fit","forgotten","forgiven","frozen","hung","hidden",
            "let","lain","lit","quit","risen","shaken","shone","shot","sunk","stuck","struck","torn","borne","bent","bred","cast",
            "dealt","forbidden","knelt","knit","led","sought","set","shrunk","slid","split","spread","sworn","swept","swung","arisen",
            "bet","fled","laid","spun","stunk","bound","clung","crept","flung","forsaken","foretold","ground","leapt","sawn","shed","slain",
            "slung","sprung","stung","striven","trodden","wept","wound","wrung"};


    String[] translations={"być","stawać się","zaczynać","łamać","przynosić","budować","kupować","łapać","wybierać",
    "przyjść/przyjechać","kosztować","ciąć kroić skaleczyć","robić","rysować pociągnąć remisować","śnić marzyć","pić",
    "prowadzić kierwoać się czymś","jeść","padać upadać spadać","czuć","znaleźć","latać","dostawać","dawać","iść","rosnąć",
            "mieć","słyszeć","uderzać","trzymać utrzymywać posiadać","ranić boleć","trzymać","znać wiedzieć","uczyć się",
            "opuszczać wyjeżdżać zostawiać","pożyczać","tracić zgubić","robić","znaczyć oznaczać mieć na myśli","spotykać poznać",
            "płacić","kłaść","czytać","jeździć","dzwonić","biec","mówić","widzieć","sprzedawać","wysyłać słać","pokazywać",
            "zamykać","śpiewać","siedzieć siadać","spać","mówić","spędzać wydawać","stać","kraść","pływać","brać","uczyć","mówić",
            "myśleć sądzić uważać","rzucać","budzić","nosić zakładać","rozumieć","wygrywać","pisać","obudzić","bić","ugryźć","krwawić",
            "wiać dmuchać","palić parzyć płonąć","kopać (np. w ziemi)","karmić żywić","walczyć bić się","pasować","zapominać",
            "wybaczać","zamarzać","zawieszać ","chować ukrywać","pozwalać","leżeć kłaść się","zapalać rozpalać oświetlać",
            "rzucać opuszczać","podnosić się wzrastać wschodzić","trząść potrząsać","świecić błyszczeć","strzelać","tonąć,zapadać się",
            "wbijać wtykać przyklejać wystawić","uderzyć wybijać","drzeć rozdzierać","znosić udźwignąć coś","zginać nachylać","hodować wychować rozmnażać się",
            "rzucić zrzucić","rozdawać postępować mieć do czynienia radzić sobie","zabraniać","klękać klęczeć","robić na drutach","prowadzić","szukać poszukiwać","umieszczać ustawiać nastawić ",
            "kurczyć się zbiegać","ślizgać się zjeżdżać","dzielić rodzielać","rozchodzić się rozprzestrzeniać rozkładać, ",
            "przysięgać przeklinać","zmiatać zamiatać","machnąć zakołysać","pojawić się","zakładać się obstawiać","umykać uciekać opuścić",
            "położyć kłaść","kręcić zakręcić czymś/się obrócić","śmierdzieć cuchnąć","wiązać złączyć oprawić","przywrzeć uczepić się trzymać się kurczowo",
            "skradać się zakradać piąć się podchodzić","rzucić cisnąć","porzucać zaniechać opuścić","przepowiadać przewidywać","zemleć rozkruszyć zgrzytać ostrzyć trzeć",
            "skakać","piłować","zrzucać pozbywać się","zabijać","cisnąć miotać","przeskakiwać wyskakiwać","żądlić","zmagać się z czymś dążyć starać się podejmować wysiłek",
            "kroczyć stąpać deptać","płakać szlochać","nawijać nakręcać wić się","wykręcić wyżąć coś wycisnąć"};

    int[] images={R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,
            R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,R.drawable.a2,

            R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,
            R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,
            R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1,
            R.drawable.b1,R.drawable.b1,R.drawable.b1,

            R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,
            R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,
            R.drawable.b2,R.drawable.b2,

            R.drawable.c1,R.drawable.c1,R.drawable.c1,R.drawable.c1,R.drawable.c1,R.drawable.c1,

            R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,
            R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2,R.drawable.c2
    };

    int[] sounds={R.raw.be,R.raw.become,R.raw.begin,R.raw.breakk,R.raw.bring,R.raw.build,R.raw.buy,R.raw.catchh,R.raw.choose,R.raw.come,R.raw.cost,R.raw.cut,R.raw.doo,R.raw.draw,
            R.raw.dream,R.raw.drink,R.raw.drive,R.raw.eat,R.raw.fall,R.raw.feel,R.raw.find,R.raw.fly,R.raw.get,R.raw.give,R.raw.go,R.raw.grow,R.raw.have,R.raw.hear,R.raw.hit,R.raw.hold,
            R.raw.hurt,R.raw.keep,R.raw.know,R.raw.learn,R.raw.leave,R.raw.lend,R.raw.lose,R.raw.make,R.raw.mean,R.raw.meetmp3,R.raw.pay,R.raw.put,R.raw.read,R.raw.ride,
            R.raw.ring,R.raw.run,R.raw.say,R.raw.see,R.raw.sell,R.raw.send,R.raw.show,R.raw.shut,R.raw.sing,R.raw.sit,R.raw.sleep,R.raw.speak,R.raw.spend,R.raw.stand,R.raw.steal,
            R.raw.swim,R.raw.take,R.raw.teach,R.raw.tell,R.raw.think,R.raw.throww,R.raw.wake,R.raw.wear,R.raw.understand,R.raw.win,R.raw.write,R.raw.awake,R.raw.beat,R.raw.bite,R.raw.bleed,
            R.raw.blow,R.raw.burn,R.raw.digmp3,R.raw.feed,R.raw.fight,R.raw.fit,R.raw.forget,R.raw.forgive,R.raw.freeze,R.raw.hang,R.raw.hide,R.raw.let,R.raw.lie,R.raw.light,
            R.raw.quit,R.raw.rise,R.raw.shake,R.raw.shine,R.raw.shoot,R.raw.sink,R.raw.stick,R.raw.strike,R.raw.tear,R.raw.bear,R.raw.bend,R.raw.breed,R.raw.cast,R.raw.deal,R.raw.forbid,
            R.raw.kneel,R.raw.knit,R.raw.lead,R.raw.seek,R.raw.set,R.raw.shrink,R.raw.slide,R.raw.split,R.raw.spread,R.raw.swear,R.raw.sweep,R.raw.swing,R.raw.arise,R.raw.bet,R.raw.flee,
            R.raw.lay,R.raw.spin,R.raw.stink,R.raw.bind,R.raw.cling,R.raw.creep,R.raw.fling,R.raw.forsake,R.raw.foretell,R.raw.grind,R.raw.leap,R.raw.saw,R.raw.shed,R.raw.slay,R.raw.sling,
            R.raw.spring,R.raw.sting,R.raw.strive,R.raw.tread,R.raw.weep,R.raw.wind,R.raw.wring
    };
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);



         context=this;


         listView = (ListView) findViewById(R.id.listView);

          adapter = new Adapter(this, firstForms, secondForms, thirdForms, translations, images);
         listView.setAdapter(adapter);

         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String melody="R.raw."+firstForms[position];

                 if(flag==true)
                 {
                     sound.stop();
                     flag=false;
                 }
                 sound=MediaPlayer.create(context,sounds[position]);
                 if(sound.isPlaying()){
                     sound.stop();
                 }
                 else
                 {
                     sound.start();
                     flag=true;
                 }
             }
         });


     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    void setFirstFormColor(int red,int green,int blue)
    {
        View view;
        for (int i = 0; i <listView.getChildCount() ; i++) {
            view= listView.getChildAt(i);
            TextView textview=(TextView) view.findViewById(R.id.modelFistForm);
            textview.setTextColor(Color.rgb(red,green,blue));
        }

    }
    void setSecondFormColor(int red,int green,int blue)
    {
        View view;
        for (int i = 0; i <listView.getChildCount() ; i++) {
            view= listView.getChildAt(i);
            TextView textview=(TextView) view.findViewById(R.id.modelSecondForm);
            textview.setTextColor(Color.rgb(red,green,blue));
        }
    }
    void setThirdFormColor(int red,int green,int blue)
    {
        View view;
        for (int i = 0; i <listView.getChildCount() ; i++) {
            view= listView.getChildAt(i);
            TextView textview=(TextView) view.findViewById(R.id.modelThridForm);
            textview.setTextColor(Color.rgb(red,green,blue));
        }
    }
    void setTranslationFormColor(int red,int green,int blue)
    {
        View view;
        for (int i = 0; i <listView.getChildCount() ; i++) {
            view= listView.getChildAt(i);
            TextView textview=(TextView) view.findViewById(R.id.modelTranslation);
            textview.setTextColor(Color.rgb(red,green,blue));
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view=(RelativeLayout) findViewById(R.id.content_main);


        switch (item.getItemId())
        {
            case R.id.blackBackground:
            {
                if(item.isChecked())
                {
                    item.setChecked(false);
                }
                else
                {
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.rgb(15,15,15));
                setFirstFormColor(175,50,50);
                setSecondFormColor(50,175,50);
                setThirdFormColor(50,50,175);
                setTranslationFormColor(255,255,255);

                return true;

            }

            case  R.id.whiteBackground:
            {
                if(item.isChecked())
                {
                    item.setChecked(false);
                }
                else
                {
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.rgb(225,225,225));
                setFirstFormColor(105,0,0);
                setSecondFormColor(0,105,0);
                setThirdFormColor(0,0,105);
                setTranslationFormColor(0,0,0);
                return true;
            }
            case  R.id.defaultBackground:
            {
                if(item.isChecked())
                {
                    item.setChecked(false);
                }
                else
                {
                    item.setChecked(true);
                }
                main_view.setBackgroundColor(Color.rgb(68,68,68));
                setFirstFormColor(255,179,179);
                setSecondFormColor(198,255,179);
                setThirdFormColor(179,198,255);
                setTranslationFormColor(255,255,255);
                return true;
            }
            default:
            {
                return super.onOptionsItemSelected(item);
            }

        }

    }





}
