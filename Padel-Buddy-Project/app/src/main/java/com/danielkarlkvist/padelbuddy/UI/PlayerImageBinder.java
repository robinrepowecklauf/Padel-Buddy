package com.danielkarlkvist.padelbuddy.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.R;

import java.util.HashMap;
import java.util.Map;

/**
 * The PlayerImageBinder class defines TODO ...
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
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
