package com.danielkarlkvist.padelbuddy.UI;

import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.R;

import java.util.HashMap;
import java.util.Map;

public class PlayerImageBinder {
    private static Map<IPlayer, Integer> playerImages = new HashMap<>();

    public static void bind(IPlayer player, int image) {
        playerImages.put(player, image);
    }

    public static int getImage(IPlayer player) {
        if (player != null) {
            Integer image = playerImages.get(player);
            if (image == null) {
                System.out.println("Image for " + player.getFullName() + " does not exist.");
            } else {
                return image;
            }
        }

        return R.drawable.no_profile_picture;
    }
}
