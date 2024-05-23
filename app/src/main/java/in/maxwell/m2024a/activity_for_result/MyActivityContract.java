package in.maxwell.m2024a.activity_for_result;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyActivityContract extends ActivityResultContract<String, String> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String s) {
        return null;
    }

    @Override
    public String parseResult(int i, @Nullable Intent intent) {
        return null;
    }
}
