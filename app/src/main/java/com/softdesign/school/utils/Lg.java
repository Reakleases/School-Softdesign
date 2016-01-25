/**
 * Класс дополняющий стандартный лог. {@link android.util.Log}
 * Форматирвоние текста по заданной длине.
 * Свой префикс для тега.
 * Assert уровень, отсутсвующий в стандратном классе.
 */

package com.softdesign.school.utils;

import android.util.Log;

public class Lg {

    /**
     * Префикс тега. (будет всегда дописан указанный текст в начале тега)
     */
    private static final String PREFIX = "SCHOOL ";

    /**
     * Максимальная длина сообщения, при превышении делается перенос строки.
     */
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    /**
     * Включение/выключение логгирования.
     */
    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
//        return true;
        return false;
    }

    /**
     * Метод проверяет включено ли логгирование и генерирует сообщения для лога в заданном уровне.
     * Добавляет в тэг префикс {@link #PREFIX}
     * А так же форматирует сообщение (делает перенос строки),
     * если оно превышает заданное значение{@link #LOGCAT_BUFFER_SIZE}
     *
     * @param code Числовое значение определяющая приоритет:
     *             Log.VERBOSE = 2
     *             Log.DEBUG = 3
     *             Log.INFO = 4
     *             Log.WARN = 5
     *             Log.ERROR = 6
     *             Log.ASSERT = 7
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    private static void getFragmented(int code, String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE) {
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE) {
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.println(code,PREFIX + tag, s1);
                }
                Log.println(code,PREFIX + tag, s);
            } else {
                Log.println(code,PREFIX + tag, text);
            }
        }


    }

    /**
     * Метод, который выдает лог на уровне INFO.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void i (String tag, String text) {
        getFragmented(Log.INFO,tag,text);
    }

    /**
     * Метод, который выдает лог на уровне ERROR.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void e (String tag, String text) {
        getFragmented(Log.ERROR,tag,text);
    }
    /**
     * Метод, который выдает лог на уровне WARN.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void w (String tag, String text) {
        getFragmented(Log.WARN,tag,text);
    }
    /**
     * Метод, который выдает лог на уровне VERBOSE.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void v (String tag, String text) {
        getFragmented(Log.VERBOSE,tag,text);
    }

    /**
     * Метод, который выдает лог на уровне DEBUG.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void d (String tag, String text) {
        getFragmented(Log.DEBUG,tag,text);
    }

    /**
     * Метод, который выдает лог на уровне ASSERT.
     * @param tag которткий текст для определения источника системного
     *            компонента которое генерирует сообщение.
     * @param text Сообщение для лога.
     */
    public static void a (String tag, String text) {
        getFragmented(Log.ASSERT,tag,text);
    }

}
