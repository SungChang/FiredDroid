package com.scalated.fireddroid;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by scalated on 9/10/16.
 */
public class FiredDroid {

    public interface DataChangeListener {
        void onDataChanged(DataSnapshot data);
    }

    public interface CancelledListener {
        void onCancelled(FirebaseError error);
    }

    public static void loadData(Firebase firebase, final DataChangeListener d) {
        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public static void loadData(Firebase firebase, final DataChangeListener d, final CancelledListener c) {
        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                c.onCancelled(firebaseError);
            }
        });
    }

    public static void addValueEventListener(Firebase firebase, final DataChangeListener d) {
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public static void addValueEventListener(Firebase firebase, final DataChangeListener d,
                                             final CancelledListener c) {
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                d.onDataChanged(dataSnapshot);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                c.onCancelled(firebaseError);
            }
        });
    }
}