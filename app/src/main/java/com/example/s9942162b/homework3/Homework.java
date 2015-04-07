package com.example.s9942162b.homework3;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.GregorianCalendar;

/**
 * Created by S9942162B on 4/7/2015.
 */
public class Homework implements Parcelable {

    protected String mTitle;
    protected boolean mCompletion;
    protected GregorianCalendar mDueDate;
    protected GregorianCalendar mRemindDate;
    protected String mNotes;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isCompletion() {
        return mCompletion;
    }

    public void setCompletion(boolean completion) {
        mCompletion = completion;
    }

    public GregorianCalendar getDueDate() {
        return mDueDate;
    }

    public void setDueDate(GregorianCalendar dueDate) {
        mDueDate = dueDate;
    }

    public GregorianCalendar getRemindDate() {
        return mRemindDate;
    }

    public void setRemindDate(GregorianCalendar remindDate) {
        mRemindDate = remindDate;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }

    public Homework(String title, boolean completion, GregorianCalendar dueDate, GregorianCalendar remindDate, String notes) {
        mTitle = title;
        mCompletion = completion;
        mDueDate = dueDate;
        mRemindDate = remindDate;
        mNotes = notes;
    }


    protected Homework(Parcel in) {
        mTitle = in.readString();
        mCompletion = in.readByte() != 0x00;
        mDueDate = (GregorianCalendar) in.readSerializable();
        mRemindDate = (GregorianCalendar) in.readSerializable();
        mNotes = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeByte((byte) (mCompletion ? 0x01 : 0x00));
        dest.writeSerializable(mDueDate);
        dest.writeSerializable(mRemindDate);
        dest.writeString(mNotes);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Homework> CREATOR = new Parcelable.Creator<Homework>() {
        @Override
        public Homework createFromParcel(Parcel in) {
            return new Homework(in);
        }

        @Override
        public Homework[] newArray(int size) {
            return new Homework[size];
        }
    };
}
