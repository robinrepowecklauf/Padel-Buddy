package com.danielkarlkvist.padelbuddy.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.IGame;
import com.danielkarlkvist.padelbuddy.Model.IPlayer;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.R;

import java.util.List;

/**
 * The GameToRecyclerViewAdapter class defines an adapter between a Game and a RecyclerView
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-10-05
 */

public class GameToRecyclerViewAdapter extends RecyclerView.Adapter<GameToRecyclerViewAdapter.GameAdViewHolder> {
    private PadelBuddy padelBuddy;
    private List<? extends IGame> games;
    private Context context;

    private boolean joinable;

    /**
     * The ViewHolder which should be updated to represent the contents of a Game.
     */

    static class GameAdViewHolder extends RecyclerView.ViewHolder {
        TextView locationTextView;
        TextView dateTextView;
        TextView skillLevelTextView;
        TextView gameLengthTextView;
        TextView resultTextView;

        TextView[] playerNameTextViews = new TextView[4];
        ImageView[] playerImagesViews = new ImageView[4];
        RatingBar[] playerRatingBars = new RatingBar[4];

        Button joinGameButton;
        Button leaveGameButton;
        Button reportResultButton;

        GameAdViewHolder(@NonNull View itemView) {
            super(itemView);

            gameLengthTextView = itemView.findViewById(R.id.game_length_textview);
            locationTextView = itemView.findViewById(R.id.location_textview);
            dateTextView = itemView.findViewById(R.id.date_textview);

            skillLevelTextView = itemView.findViewById(R.id.skilllevel_textview);

            playerImagesViews[0] = itemView.findViewById(R.id.player1_imageview);
            playerImagesViews[1] = itemView.findViewById(R.id.player2_imageview);
            playerImagesViews[2] = itemView.findViewById(R.id.player3_imageview);
            playerImagesViews[3] = itemView.findViewById(R.id.player4_imageview);

            playerNameTextViews[0] = itemView.findViewById(R.id.player1_name_textview);
            playerNameTextViews[1] = itemView.findViewById(R.id.player2_name_textview);
            playerNameTextViews[2] = itemView.findViewById(R.id.player3_name_textview);
            playerNameTextViews[3] = itemView.findViewById(R.id.player4_name_textview);

            playerRatingBars[0] = itemView.findViewById(R.id.player1_ratingbar);
            playerRatingBars[1] = itemView.findViewById(R.id.player2_ratingbar);
            playerRatingBars[2] = itemView.findViewById(R.id.player3_ratingbar);
            playerRatingBars[3] = itemView.findViewById(R.id.player4_ratingbar);

            for (RatingBar ratingBar : playerRatingBars) {
                ratingBar.setStepSize(0.1f);
            }

            joinGameButton = itemView.findViewById(R.id.join_game_button);
            leaveGameButton = itemView.findViewById(R.id.leave_game_button);
            reportResultButton = itemView.findViewById(R.id.report_result_button);

            resultTextView = itemView.findViewById(R.id.result_textview);
        }
    }

    GameToRecyclerViewAdapter(List<? extends IGame> games, PadelBuddy padelBuddy, boolean joinable, Context context) {
        this.games = games;
        this.context = context;
        this.padelBuddy = padelBuddy;
        this.joinable = joinable;
    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @NonNull
    @Override
    public GameAdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameAdViewHolder gameAdViewHolder = new GameAdViewHolder(view);
        return gameAdViewHolder;
    }

    // Called by RecyclerView to display the data from Game at the specified position.
    @Override
    public void onBindViewHolder(@NonNull final GameAdViewHolder holder, int position) {
        final IGame currentGame = games.get(position);
        // Set location
        holder.locationTextView.setText(currentGame.getLocation());
        // Set date
        holder.dateTextView.setText(currentGame.getDateAsString());
        // Set skill level
        holder.skillLevelTextView.setText(currentGame.getAverageSkillLevel());

        holder.gameLengthTextView.setText(currentGame.getGameLength());

        // Set name and rating for all (4) players
        for (int i = 0; i < currentGame.getPlayers().length; i++) {
            IPlayer player = currentGame.getPlayers()[i];
            if (player != null) {
                holder.playerNameTextViews[i].setText(player.getFirstname());
                Bitmap playerImage = PlayerImageBinder.getImage(player, context);
                holder.playerImagesViews[i].setImageBitmap(playerImage);
                holder.playerRatingBars[i].setVisibility(View.VISIBLE);
                holder.playerRatingBars[i].setRating(player.getProfileRating());
            } else {
                holder.playerNameTextViews[i].setText("Tillgänglig");
                holder.playerImagesViews[i].setImageResource(R.drawable.waiting_for_player_picture);
                holder.playerRatingBars[i].setVisibility(View.INVISIBLE);
            }
        }

        holder.joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                padelBuddy.joinGame(currentGame);
            }
        });

        holder.leaveGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                padelBuddy.leaveGame(currentGame);
            }
        });

        holder.reportResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.reportResultButton.setVisibility(View.INVISIBLE);
                holder.resultTextView.setVisibility(View.VISIBLE);

            }
        });

        if(!joinable){
            holder.joinGameButton.setVisibility(View.INVISIBLE);
            holder.leaveGameButton.setVisibility(View.VISIBLE);

            if(!padelBuddy.isGameDateAfterToday(currentGame)){
                holder.reportResultButton.setVisibility(View.VISIBLE);
                holder.leaveGameButton.setVisibility(View.INVISIBLE);
            }
        }

    }

    // Returns the total number of items in the data set held by the adapter.
    @Override
    public int getItemCount() {
        return games.size();
    }
}
