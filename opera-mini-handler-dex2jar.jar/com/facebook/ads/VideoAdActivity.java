// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads;

import com.facebook.ads.internal.action.AdActionFactory;
import com.facebook.ads.internal.action.AppAdAction;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import com.facebook.ads.internal.HtmlAdDataModel;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer$OnCompletionListener;
import android.media.MediaPlayer$OnPreparedListener;
import android.view.View$OnClickListener;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import java.util.Arrays;
import java.util.Iterator;
import android.widget.RelativeLayout;
import android.net.Uri;
import android.widget.VideoView;
import android.view.View;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.ImageButton;
import java.util.List;
import android.app.Activity;

public class VideoAdActivity extends Activity
{
    private static final long CONTROLS_FADE_DELAY = 3000L;
    public static final String MARKET_URI_INTENT_EXTRA = "adMarketUri";
    public static final String URI_INTENT_EXTRA = "adUri";
    public static final String VIDEO_PATH_INTENT_EXTRA = "adVideoPath";
    private List mAllControls;
    private List mBufferingView;
    private ImageButton mCloseButton;
    private int mCurrentPosition;
    private List mEndControls;
    private List mFullPlayingControls;
    private boolean mGoToAppStore;
    private Handler mHandler;
    private ImageButton mInstallButton;
    private boolean mIsMuted;
    private MediaPlayer mMediaPlayer;
    private List mMinPlayingControls;
    private ImageButton mMuteButton;
    private List mPausedControls;
    private View mRootView;
    private ImageButton mSkipButton;
    private VideoAdActivity$PlayerState mState;
    private long mTimeOfLastTouch;
    private VideoView mVideoView;
    private Uri marketUri;
    private String path;
    private RelativeLayout relativeLayout;
    private String uniqueId;
    private Uri uri;
    
    public VideoAdActivity() {
        this.mIsMuted = false;
        this.mCurrentPosition = -1;
        this.mHandler = new Handler();
        this.mGoToAppStore = false;
    }
    
    private void activateControlSet(final List list) {
        for (final ImageButton imageButton : this.mAllControls) {
            if (list.contains(imageButton)) {
                imageButton.setVisibility(0);
            }
            else {
                imageButton.setVisibility(8);
            }
        }
    }
    
    private void bindModel() {
        this.setState(VideoAdActivity$PlayerState.UNINITIALIZED);
        this.mInstallButton.setBackground(this.getResources().getDrawable(17301633));
        this.mSkipButton.setBackground(this.getResources().getDrawable(17301569));
        this.mMuteButton.setBackground(this.getResources().getDrawable(17301554));
        this.mCloseButton.setBackground(this.getResources().getDrawable(17301560));
        this.mVideoView.setVideoPath(this.path);
    }
    
    private void configureLayout() {
        this.relativeLayout.addView(this.mRootView);
        this.relativeLayout.addView((View)this.mInstallButton);
        this.relativeLayout.addView((View)this.mSkipButton);
        this.relativeLayout.addView((View)this.mMuteButton);
        this.relativeLayout.addView((View)this.mCloseButton);
    }
    
    private void configureViews() {
        this.mAllControls = Arrays.asList(this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton);
        this.mFullPlayingControls = Arrays.asList(this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton);
        this.mMinPlayingControls = Arrays.asList(this.mCloseButton, this.mInstallButton, this.mSkipButton);
        this.mPausedControls = Arrays.asList(this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton);
        this.mEndControls = Arrays.asList(this.mInstallButton, this.mMuteButton, this.mCloseButton, this.mSkipButton);
        this.mBufferingView = Arrays.asList(this.mInstallButton, this.mCloseButton, this.mSkipButton);
        final View$OnTouchListener view$OnTouchListener = (View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.5f);
                }
                else if (motionEvent.getAction() == 1) {
                    view.setAlpha(1.0f);
                }
                return false;
            }
        };
        this.mInstallButton.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.mSkipButton.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.mMuteButton.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.mCloseButton.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.mInstallButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                VideoAdActivity.this.mGoToAppStore = true;
                VideoAdActivity.this.finish();
            }
        });
        this.mSkipButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                VideoAdActivity.this.displayInterstitial();
            }
        });
        this.mMuteButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                VideoAdActivity.this.videoMute();
            }
        });
        this.mCloseButton.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                VideoAdActivity.this.finish();
            }
        });
        this.mRootView.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                VideoAdActivity.this.pulseControlsFromTouch();
                return false;
            }
        });
        this.mVideoView.setOnPreparedListener((MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
            public void onPrepared(final MediaPlayer mediaPlayer) {
                VideoAdActivity.this.mMediaPlayer = mediaPlayer;
                if (VideoAdActivity.this.mIsMuted) {
                    VideoAdActivity.this.mMediaPlayer.setVolume(0.0f, 0.0f);
                }
                else {
                    VideoAdActivity.this.mMediaPlayer.setVolume(1.0f, 1.0f);
                }
                VideoAdActivity.this.updateVideoPlayerSize();
                if (VideoAdActivity.this.mState == VideoAdActivity$PlayerState.PAUSED || VideoAdActivity.this.mState == VideoAdActivity$PlayerState.COMPLETED) {
                    VideoAdActivity.this.mMediaPlayer.seekTo(VideoAdActivity.this.mCurrentPosition);
                }
                else {
                    if (VideoAdActivity.this.mState == VideoAdActivity$PlayerState.PLAYING) {
                        VideoAdActivity.this.mMediaPlayer.seekTo(VideoAdActivity.this.mCurrentPosition);
                        VideoAdActivity.this.videoPlay();
                        return;
                    }
                    if (VideoAdActivity.this.mState == VideoAdActivity$PlayerState.UNINITIALIZED) {
                        VideoAdActivity.this.setState(VideoAdActivity$PlayerState.INITIALIZED);
                        VideoAdActivity.this.videoPlay();
                    }
                }
            }
        });
        this.mVideoView.setOnCompletionListener((MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public void onCompletion(final MediaPlayer mediaPlayer) {
                VideoAdActivity.this.setState(VideoAdActivity$PlayerState.COMPLETED);
                VideoAdActivity.this.displayInterstitial();
            }
        });
        this.mVideoView.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                VideoAdActivity.this.pulseControlsFromTouch();
                return false;
            }
        });
    }
    
    private void displayInterstitial() {
        final Intent intent = new Intent((Context)this, (Class)InterstitialAdActivity.class);
        final Display defaultDisplay = ((WindowManager)this.getSystemService("window")).getDefaultDisplay();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        intent.putExtra("displayRotation", defaultDisplay.getRotation());
        intent.putExtra("displayWidth", displayMetrics.widthPixels);
        intent.putExtra("displayHeight", displayMetrics.heightPixels);
        intent.putExtra("adInterstitialUniqueId", this.uniqueId);
        HtmlAdDataModel.fromIntentExtra(this.getIntent()).addToIntentExtra(intent);
        this.startActivity(intent);
        this.finish();
    }
    
    private void getIntentExtras() {
        final Bundle extras = this.getIntent().getExtras();
        this.uri = Uri.parse(extras.getString("adUri"));
        this.marketUri = Uri.parse(extras.getString("adMarketUri"));
        this.path = extras.getString("adVideoPath");
        this.uniqueId = extras.getString("adInterstitialUniqueId");
    }
    
    private void pulseControlsFromTouch() {
        this.mTimeOfLastTouch = System.currentTimeMillis();
        this.updateControlState();
        this.mHandler.removeCallbacksAndMessages((Object)null);
        this.mHandler.postDelayed((Runnable)new Runnable() {
            @Override
            public void run() {
                VideoAdActivity.this.updateControlState();
            }
        }, 3000L);
    }
    
    private void setButtonPosition() {
        this.mInstallButton.setX(270.0f);
        this.mInstallButton.setY(1400.0f);
        this.mSkipButton.setX(700.0f);
        this.mSkipButton.setY(1400.0f);
        this.mMuteButton.setX(10.0f);
        this.mMuteButton.setY(1160.0f);
        this.mCloseButton.setX(970.0f);
        this.mInstallButton.setScaleX(1.5f);
        this.mInstallButton.setScaleY(1.5f);
        this.mSkipButton.setScaleX(1.5f);
        this.mSkipButton.setScaleY(1.5f);
    }
    
    private void setState(final VideoAdActivity$PlayerState mState) {
        if (mState != this.mState) {
            this.mState = mState;
            this.pulseControlsFromTouch();
        }
    }
    
    private void updateControlState() {
        this.mInstallButton.setAlpha(1.0f);
        this.mSkipButton.setAlpha(1.0f);
        this.mCloseButton.setAlpha(1.0f);
        this.mVideoView.setAlpha(1.0f);
        switch (this.mState) {
            default: {}
            case PLAYING: {
                if (System.currentTimeMillis() - this.mTimeOfLastTouch >= 3000L) {
                    this.activateControlSet(this.mMinPlayingControls);
                    this.mInstallButton.setAlpha(0.5f);
                    this.mSkipButton.setAlpha(0.5f);
                    this.mCloseButton.setAlpha(0.5f);
                    return;
                }
                this.activateControlSet(this.mFullPlayingControls);
            }
            case PAUSED: {
                this.activateControlSet(this.mPausedControls);
            }
            case UNINITIALIZED: {
                this.activateControlSet(this.mBufferingView);
            }
            case INITIALIZED: {
                this.activateControlSet(this.mBufferingView);
            }
            case COMPLETED: {
                this.activateControlSet(this.mEndControls);
                this.mMediaPlayer.seekTo((int)(this.mMediaPlayer.getDuration() * 0.75f));
                this.mVideoView.setAlpha(1.0f);
            }
        }
    }
    
    private void updateVideoPlayerSize() {
        if (this.mMediaPlayer != null) {
            final float min = Math.min(this.mRootView.getWidth() / (float)this.mMediaPlayer.getVideoWidth(), this.mRootView.getHeight() / (float)this.mMediaPlayer.getVideoHeight());
            this.mVideoView.getHolder().setFixedSize((int)(this.mMediaPlayer.getVideoWidth() * min), (int)(min * this.mMediaPlayer.getVideoHeight()));
            this.mVideoView.requestLayout();
            this.mVideoView.invalidate();
        }
    }
    
    private void videoBackground() {
        if (this.mVideoView.isPlaying()) {
            this.mCurrentPosition = this.mVideoView.getCurrentPosition();
        }
        this.mVideoView.pause();
        this.mHandler.removeCallbacksAndMessages((Object)null);
        this.mMediaPlayer = null;
    }
    
    private void videoMute() {
        if (this.mState != VideoAdActivity$PlayerState.UNINITIALIZED) {
            if (this.mIsMuted) {
                this.mMediaPlayer.setVolume(1.0f, 1.0f);
                this.mMuteButton.setBackground(this.getResources().getDrawable(17301554));
            }
            else {
                this.mMediaPlayer.setVolume(0.0f, 0.0f);
                this.mMuteButton.setBackground(this.getResources().getDrawable(17301553));
            }
            this.mIsMuted = !this.mIsMuted;
        }
    }
    
    private void videoPlay() {
        if (this.mState != VideoAdActivity$PlayerState.UNINITIALIZED && this.mState != VideoAdActivity$PlayerState.PLAYING) {
            if (this.mState == VideoAdActivity$PlayerState.COMPLETED) {
                this.mVideoView.seekTo(0);
            }
            this.mVideoView.start();
            this.mCurrentPosition = this.mVideoView.getCurrentPosition();
            this.setState(VideoAdActivity$PlayerState.PLAYING);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                VideoAdActivity.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
                VideoAdActivity.this.updateVideoPlayerSize();
            }
        });
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        this.relativeLayout = new RelativeLayout((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams.addRule(15);
        this.setContentView((View)this.relativeLayout, (ViewGroup$LayoutParams)layoutParams);
        (this.mVideoView = new VideoView((Context)this)).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.relativeLayout.addView((View)this.mVideoView);
        this.mRootView = new View((Context)this);
        this.mInstallButton = new ImageButton((Context)this);
        this.mSkipButton = new ImageButton((Context)this);
        this.mMuteButton = new ImageButton((Context)this);
        this.mCloseButton = new ImageButton((Context)this);
        this.getIntentExtras();
        this.setVolumeControlStream(3);
        this.configureViews();
        this.bindModel();
        this.setButtonPosition();
        this.configureLayout();
    }
    
    protected void onDestroy() {
        super.onDestroy();
        if (this.mGoToAppStore) {
            ((AppAdAction)AdActionFactory.getAdAction((Context)this, this.uri)).goToMarketURL();
        }
    }
    
    protected void onPause() {
        super.onPause();
        this.videoBackground();
    }
    
    protected void onResume() {
        super.onResume();
        if (this.mState == VideoAdActivity$PlayerState.PLAYING && !this.mVideoView.isPlaying()) {
            this.mVideoView.seekTo(this.mCurrentPosition);
            this.mVideoView.start();
        }
        this.pulseControlsFromTouch();
    }
    
    protected void onStop() {
        super.onStop();
        this.videoBackground();
    }
}
