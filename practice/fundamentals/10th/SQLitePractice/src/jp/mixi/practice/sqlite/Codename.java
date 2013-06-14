package jp.mixi.practice.sqlite;

import android.provider.BaseColumns;

public class Codename implements BaseColumns {

    @SuppressWarnings("unused")
    private static final String TAG = Codename.class.getSimpleName();

    public static final String CODENAME_TABLE_NAME = "android_code_name";

    public static final String COLUMN_NAME_CODENAME_NAME = "name";
    public static final String COLUMN_NAME_CODENAME_VERSION = "version";

    private String mName;
    private String mVersion;

    public Codename(String name, String version, int price) {
        super();
        mName = name;
        mVersion = version;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
