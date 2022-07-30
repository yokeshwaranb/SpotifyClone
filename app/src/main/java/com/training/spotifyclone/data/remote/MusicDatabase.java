package com.training.spotifyclone.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.training.spotifyclone.data.entities.Song;
import com.training.spotifyclone.other.Constants;

import java.util.List;

public class MusicDatabase {

    private static final String TAG = "Spotify.MyMusicDatabase";

    private FirebaseFirestore fireStore = FirebaseFirestore.getInstance();
    private CollectionReference songCollection = fireStore.collection(Constants.SONGS_COLLECTION);

    synchronized public void getAllSongs() {
        Log.d(TAG, "getAllSongs() called");
        songCollection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    Log.d(TAG, "getAllSongs successful");
                    QuerySnapshot querySnapshot = task.getResult();


                    /**
                     This one way to get the data by giving field name.

                     List<DocumentSnapshot> documentSnapshots = querySnapshot.getDocuments();
                    if(documentSnapshots.isEmpty()) {
                        Log.d(TAG, "Document is empty");
                    }
                    for(DocumentSnapshot document: documentSnapshots) {
                        String mediaId = (String) document.get("mediaId");
                        String title = (String) document.get("title");
                        Log.d(TAG, "Document " + mediaId + " " + title);
                    }
                   */

                    List<Song> songs = querySnapshot.toObjects(Song.class);
                    if(songs.isEmpty()) {
                        // Set No data
                        Log.d(TAG, "Document is empty");
                    }
                    else {
                        // Set the received data
                        for (Song song: songs) {
                            Log.d(TAG, "@Documents " + song.getMediaId() + " " + song.getTitle());
                        }
                    }
                }
                else {
                    // Set Error
                    Log.d(TAG, "getAllSongs failed");
                }
            }
        });
    }
}
