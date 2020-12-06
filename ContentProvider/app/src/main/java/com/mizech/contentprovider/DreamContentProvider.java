package com.mizech.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mizech.contentprovider.model.Dream;

import java.util.Objects;

public class DreamContentProvider extends ContentProvider {
    private DreamDao dreamDao;

    private final String TAG = DreamContentProvider.class.getClass().toString();

    public static final  String AUTHORITY = "com.mizech.contentprovider";
    public static final String DREAM_TABLE = "dream_tbl";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String DESCRIPTION = "description";

    public static final int DREAMS = 1;
    public static final int DREAM_ID = 2;

    public static final String URL = "content://" + AUTHORITY + "/" + DREAM_TABLE;
    public static final Uri CONTENT_URI = Uri.parse(URL);

    public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, DREAM_TABLE, DREAMS);
        uriMatcher.addURI(AUTHORITY, DREAM_TABLE + "/#", DREAM_ID);
    }

    @Override
    public boolean onCreate() {
        dreamDao = ApplicationDatabase.getInstance(getContext()).getDreamDao();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        Log.d(TAG, "Query");

        Cursor cursor;

        switch (uriMatcher.match(uri)) {
            case DREAMS:
                cursor = dreamDao.findAll();

                if (getContext() != null) {
                    cursor.setNotificationUri(
                            getContext().getContentResolver(),
                            uri);
                    return cursor;
                }
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case DREAMS:
                return "vnd.android.cursor.dir/" + DREAM_TABLE;
            default:
                throw new IllegalArgumentException("Unsupported URI");
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.d(TAG, "Insert");

        switch (uriMatcher.match(uri)) {
            case DREAMS:
                if (getContext() != null) {
                    long id = dreamDao.insert(Dream.fromContentValue(values));
                    if (id != 0) {
                        getContext().getContentResolver().notifyChange(uri, null);
                        return ContentUris.withAppendedId(uri, id);
                    }
                }
            case DREAM_ID:
                throw new IllegalArgumentException("Invalid URI!");
            default:
                throw new IllegalArgumentException("Unknown URI.");
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;

        Log.d(TAG, "Delete");

        switch (uriMatcher.match(uri)) {
            case DREAMS:
                if (getContext() != null) {
                    count = dreamDao.deleteAll();
                    getContext().getContentResolver().notifyChange(uri, null);
                    return count;
                }
            case DREAM_ID:
                if (getContext() != null) {
                    count = dreamDao.delete(ContentUris.parseId(uri));
                    getContext().getContentResolver().notifyChange(uri, null);
                    return count;
                }
            default:
                throw new IllegalArgumentException("Unknown URI!");
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.d(TAG, "Update");

        switch (uriMatcher.match(uri)) {
            case DREAMS:
                if (getContext() != null) {
                    int count = dreamDao.update(Dream.fromContentValue(Objects.requireNonNull(values)));

                    if (count != 0) {
                        getContext().getContentResolver().notifyChange(uri, null);
                        return count;
                    }
                }
            case DREAM_ID:
                throw new IllegalArgumentException("Invalid URI.");
            default:
                throw new IllegalArgumentException("Unknown URI.");
        }
    }
}
