package com.danielkarlkvist.padelbuddy.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import com.danielkarlkvist.padelbuddy.BuildConfig;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.R;

import java.util.HashMap;
import java.util.Map;

public class PlayerImageBinder {
    private static Map<IPlayer, Bitmap> playerImages = new HashMap<>();

    public static void bind(IPlayer player, Bitmap image) {
        playerImages.put(player, image);
    }

    public static Bitmap getImage(IPlayer player, Context context) {
        if (player != null) {
            Bitmap image = playerImages.get(player);
            if (image == null) {
                System.out.println("Image for " + player.getFullName() + " does not exist.");
            } else {
                return image;
            }
        }

        return BitmapFactory.decodeResource(context.getResources(), R.drawable.no_profile_picture);
    }
}
