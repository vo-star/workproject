package com.example.mtg_deck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DeckDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "deck"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    DeckDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    private static void insertEnters1(SQLiteDatabase db, String color){
        ContentValues colorsEnters = new ContentValues();
        colorsEnters.put("COLOR", color);
        db.insert("COLORS", null, colorsEnters);
    }
    private static void insertEnters2(SQLiteDatabase db, String type, String color, String com) {
        ContentValues blueEnters = new ContentValues();
        blueEnters.put("TYPE", type);
        blueEnters.put("COLOR", color);
        blueEnters.put("COM", com);
        db.insert("DECK_COLORS", null, blueEnters);
    }
    private static void insertEnters3(SQLiteDatabase db,String color,  String type, String card, int resursID, int sign) {
        ContentValues cardEnters = new ContentValues();

        cardEnters.put("COLOR", color);
        cardEnters.put("TYPE", type);
        cardEnters.put("CARD", card);
        cardEnters.put("RESURSID", resursID);
        cardEnters.put("SIGN", sign);

        db.insert("CARDS", null, cardEnters);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE COLORS (_id INTEGER PRIMARY KEY AUTOINCREMENT, COLOR TEXT); " );
        Log.i("MyLog", "After create table1");
        //added headers
        insertEnters1(db, "Типы");
        insertEnters1(db, "Побитовые операторы");
//        insertEnters1(db, "Операторы сравнения");
//        insertEnters1(db, "Логические операторы");
//        insertEnters1(db, "Литералы");
//        insertEnters1(db, "Оператор if");
//        insertEnters1(db, "Оператор switch");
//        insertEnters1(db, "Цикл while");
//        insertEnters1(db, "Цикл do-while");
//        insertEnters1(db, "Цикл for");
//        insertEnters1(db, "Операторы перехода break, continue, return");
//        insertEnters1(db, "Классы и объекты");
//        insertEnters1(db, "Класс Object");
//        insertEnters1(db, "Методы");
//        insertEnters1(db, "Видимость. Спецификаторы доступа");
//        insertEnters1(db, "Ключевое слово static");
//        insertEnters1(db, "Вложенные и внутренние классы");
//        insertEnters1(db, "Конструктор");
//        insertEnters1(db, "Шаблон Builder");
//        insertEnters1(db, "Шаблон Singleton");
//        insertEnters1(db, "Наследование");
//        insertEnters1(db, "Абстрактные классы и методы");
//        insertEnters1(db, "Пакеты");
//        insertEnters1(db, "Интерфейсы");
//        insertEnters1(db, "Слушатели");
//        insertEnters1(db, "Исключения");
//        insertEnters1(db, "Потоки. Класс Thread и интерфейс Runnable");
//        insertEnters1(db, "Перечисления enum");
//        insertEnters1(db, "Обобщения (Generic)");
//        insertEnters1(db, "Рекурсия");
//        insertEnters1(db, "Класс String");
//        insertEnters1(db, "Класс Scanner");
//        insertEnters1(db, "Класс Math");
//        insertEnters1(db, "Классы Date, Calendar, DateFormat");
//        insertEnters1(db, "Класс Currency");
//        insertEnters1(db, "Locale");
//        insertEnters1(db, "Массивы");
//        insertEnters1(db, "Stack");
//        insertEnters1(db, "Коллекции");
//        insertEnters1(db, " ArrayList");
//        insertEnters1(db, " LinkedList");
//        insertEnters1(db, "Множества: Set, HashSet, LinkedHashSet, TreeSet");
//        insertEnters1(db, "Map (Отображение)");
//        insertEnters1(db, "HashMap");
//        insertEnters1(db, " LinkedHashMap");
//        insertEnters1(db, "  ArrayMap и SparseArray");
//        insertEnters1(db, "Интерфейс Comparable");
//        insertEnters1(db, "Интерфейс Comparator");
//        insertEnters1(db, "Система ввода/вывода");
//        insertEnters1(db, " Класс File");
//        insertEnters1(db, "  Класс InputStream");
//        insertEnters1(db, " Класс PrintStream");
//        insertEnters1(db, "Классы NIO");
//        insertEnters1(db, "Random");
//        insertEnters1(db, "Таймер - классы Timer и TimerTask");
//        insertEnters1(db, "Обработка событий");
//        insertEnters1(db, "Регулярные выражения");
        Log.i("MyLog", "After insert1");
        db.execSQL("CREATE TABLE DECK_COLORS (_id INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, COLOR TEXT, COM TEXT); " );
        Log.i("MyLog", "After create table2");


        //added note

        insertEnters2(db, "", "Типы", "Примитивные типы Java не являются объектами. К ним относятся:");
        insertEnters2(db," ", "Типы"," boolean - булев тип, может иметь значения true или false");
        insertEnters2(db," ", "Типы","byte - 8-разрядное целое число");
        insertEnters2(db," ", "Типы"," short - 16-разрядное целое число");
        insertEnters2(db," ", "Типы"," int - 32-разрядное целое число");
        insertEnters2(db," ", "Типы"," long - 64-разрядное целое число");
        insertEnters2(db," ", "Типы"," char - 16-разрядное беззнаковое целое, представляющее собой символ UTF-16 (буквы и цифры)");
        insertEnters2(db," ", "Типы","float - 32-разрядное число в формате IEEE 754 с плавающей точкой");
        insertEnters2(db," ", "Типы"," double - 64-разрядное число в формате IEEE 754 с плавающей точкой");
        insertEnters2(db," ", "Типы",   " Примитивный в данном случае не оскорбление, а просто даёт понять, что речь идёт о простом типе, который не умеет прыгать, спать или мяукать. Да что он вообще умеет? Ой, всё."
                +       " Java определяет четыре целочисленных типа: byte, short, int, long. Они могут быть положительными и отрицательными (Java не поддерживает только положительные значения без знака, как некоторые языки программирования)."
                +      " Тип byte "
                +" Наименьший по размеру целочисленный тип - byte. Это 8-битовый тип с диапазоном допустимых значений от -128 до 127. Переменные типа byte часто используются при работе с потоком данных из сети или файла, а также при работе с необработанными двоичными данными или в массивах для экономии памяти. "

                +       " Объявить переменную типа byte можно следующим образом: ");

        insertEnters2(db," ", "Типы","");
        insertEnters2(db," ", "Типы"," byte c, a, t; // объявили сразу три переменные ");
        insertEnters2(db," ", "Типы"," ");
        insertEnters2(db," ", "Типы",    " В арифметических выражениях с переменными типа byte вычисления выполняются как с типом int, т.е. с помощью 32-битовой арифметики, а полученный результат будет 32-битовым. Смотри пример с short." +
                              " Строку с числом перевести в данный тип можно через метод parseByte(String): " +
                        "\n" +
                        " byte x = Byte.parseByte('100'); " +
                "\n"+
                         "Класс Byte является оболочкой для данного типа. Без необходимости не используйте в Android класс Byte. " +
                " Слово «байт» (byte) возникло в компании IBM примерно в 1956 году. Оно произошло от слова bite («кусок»), но его было решено писать через букву y, чтобы не путать со словом «bit» («бит»). В течение некоторого времени слово «байт» обозначало просто число битов в конкретном потоке данных. Однако в середине 1960-х, в связи с разработкой семейства компьютеров System/360 в компании IBM, это слово стало обозначать группу из восьми бит." +
                " Любопытно, что bite имеет также значение 'укус' (сущ.) или 'укусить' (глагол). Таким образом это наш родной 'Кусь!'\");"
        +  " В арифметических выражениях с переменными типа byte вычисления выполняются как с типом int, т.е. с помощью 32-битовой арифметики, а полученный результат будет 32-битовым. Смотри пример с short."
                + " Строку с числом перевести в данный тип можно через метод parseByte(String): "
                + " byte x = Byte.parseByte('100'); "
                + " Класс Byte является оболочкой для данного типа. Без необходимости не используйте в Android класс Byte. "
                + " Слово «байт» (byte) возникло в компании IBM примерно в 1956 году. Оно произошло от слова bite («кусок»), но его было решено писать через букву y, чтобы не путать со словом «bit» («бит»). В течение некоторого времени слово «байт» обозначало просто число битов в конкретном потоке данных. Однако в середине 1960-х, в связи с разработкой семейства компьютеров System/360 в компании IBM, это слово стало обозначать группу из восьми бит. "
                + " Любопытно, что bite имеет также значение 'укус' (сущ.) или 'укусить' (глагол). Таким образом это наш родной 'Кусь!'");





        insertEnters2(db, "", "Побитовые операторы","Существует несколько побитовых операторов, применимых к целочисленными типам long, int, short, char, byte.");
        insertEnters2(db, "", "Побитовые операторы", "~\tПобитовый унарный оператор NOT");
        insertEnters2(db, "", "Побитовые операторы","&\tПобитовый AND");
        insertEnters2(db, "", "Побитовые операторы","&=\tПобитовый AND с присваиванием");
        insertEnters2(db, "", "Побитовые операторы","|\tПобитовый OR");
        insertEnters2(db, "", "Побитовые операторы","|=\tПобитовый OR с присваиванием");
        insertEnters2(db, "", "Побитовые операторы","^\tПобитовый исключающее OR");
        insertEnters2(db, "", "Побитовые операторы","^=\tПобитовый исключающее OR с присваиванием");
        insertEnters2(db, "", "Побитовые операторы",">>\tСдвиг вправо");
        insertEnters2(db, "", "Побитовые операторы",">>=\tСдвиг вправо с присваиванием");
        insertEnters2(db, "", "Побитовые операторы",">>>\tСдвиг вправо с заполнением нулями");
        insertEnters2(db, "", "Побитовые операторы","<<\tСдвиг влево");
        insertEnters2(db, "", "Побитовые операторы","<<=\tСдвиг влево с присваиванием");
        insertEnters2(db, "", "Побитовые операторы",">>>=\tСдвиг вправо с заполнением нулями с присваиванием");
        insertEnters2(db, "", "Побитовые операторы","Все целочисленные типы представляются двоичными числами различной длины. Например, значение типа byte, равное 42, в двоичном представлении имеет вид 00101010, в котором каждая позиция представляет степень числа два."
        +"\n"
        +"\nВсе целочисленные типа, за исключением char - типы со знаком, т.е. могут быть положительными или отрицательными. В Java применяется двоичное дополнение, при котором отрицательные числа представляются в результате инвертирования всех битов значения (изменения 1 на 0 и наоборот) и последующего добавления 1 к результату. Например, -42 представляется в результате инвертирования всех битов в двоичном представлении числа 42, что даёт значение 11010101, и добавления 1, что приводит к значению 110110110, или -42. Чтобы декодировать отрицательное число, необходимо вначале инвертировать все биты, а затем добавить 1 к результату. Например, инвертирование значения -42, или 11010110, приводит к значению 00101001, или 41, после добавления 1 к которому мы получим 42."
        +"\n"
        +"\nДвоичное дополнение используется в большинстве компьютерных языков. Опустим теорию, нужно только помнить, что старший бит определяет знак целого числа.");
        insertEnters2(db, "", "Побитовые операторы","");
        insertEnters2(db, "", "Побитовые операторы","Побитовые логические операторы");
        insertEnters2(db, "", "Побитовые операторы","");
        insertEnters2(db, "", "Побитовые операторы","Побитовые логические операторы - это &, |, ^, ~. Побитовые операторы применяются к каждому отдельному биту каждого операнда.");
        insertEnters2(db, "", "Побитовые операторы","");
        insertEnters2(db, "", "Побитовые операторы","Результаты выполнения побитовых логических операторов");
        insertEnters2(db, "", "Побитовые операторы","");
        insertEnters2(db, "", "Побитовые операторы","A      B       A|B     A&B     A^B     ~A"
                                                                        +"\n"
        +                                                           " 0       0         0       0         0            1"
                +"\n"
        +                                                           " 1       0         1       0         1            0"
                +"\n"
        +                                                           " 0       1         1       0         1            1"
                +"\n"
        +                                                           " 1       1         1       1         0            0"

                                                            );
        insertEnters2(db, "", "Побитовые операторы","");
        insertEnters2(db, "", "Побитовые операторы","1\t0\t1\t0\t1\t0");
        insertEnters2(db, "", "Побитовые операторы","0\t1\t1\t0\t1\t1");
        insertEnters2(db, "", "Побитовые операторы","1\t1\t1\t1\t0\t0");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");
//        insertEnters2(db, "", "Побитовые операторы","");

//
//
//
//
//
//
//        insertEnters2(db, "CAVALCADE","MONO-RED","");
//
//
//
//
//
//
//        insertEnters2(db, "VAMPIRES", "MONO-BLACK","");
//
//
//
//
//
//        insertEnters2(db, "DISCARD","MONO-BLACK","");
//
//
//
//
//
//
//        insertEnters2(db, "NISSA", "MONO-GREEN","");
//
//
//
//
//
//        insertEnters2(db, "FOOD","MONO-GREEN","");
//
//
//
//
//
//        insertEnters2(db, "LIFE", "MONO-WHITE","");
//
//
//
//
//
//        insertEnters2(db, "WEENIE","MONO-WHITE","");
//
//
//
//



        Log.i("MyLog", "After insert2");
        db.execSQL("CREATE TABLE CARDS (_id INTEGER PRIMARY KEY AUTOINCREMENT,COLOR TEXT ,TYPE TEXT , CARD TEXT, RESURSID INTEGER, SIGN INTEGER); " );
        insertEnters3(db, "MONO-BLUE","MILS" , "4 Мерфолк, Хранительница Тайн", R.drawable.merfolk, 0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Ошеломленная Ученица", R.drawable.lener, 0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Горгулья Вантресса", R.drawable.gorg,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Стена Потерянных Мыслей", R.drawable.faol,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Холодный Отказ", R.drawable.coald,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Скажи Волшебное Слово", R.drawable.woard,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Распад Мыслей", R.drawable.one,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Попасть в Историю", R.drawable.two,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Ведьмин Колодец", R.drawable.three,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Затонувшие Тайны",  R.drawable.five,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "1 Замок Вантресс",  R.drawable.six,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "17 Остров",  R.drawable.seven,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Мистическое Святилище",  R.drawable.thore,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "",  0 ,1);
        insertEnters3(db, "MONO-BLUE", "MILS", "Доп. колода:",  0 ,1);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Такой Крохотный",  R.drawable.sid1 ,0);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
