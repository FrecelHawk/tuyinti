package org.tuyinti.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

public class AnimationUtils {

	public static void playHeartBeatAnimation(final Activity context, final View view, final float radio) {
		new Thread() {
			public void run() {
				while (true) {
					sleep();
					context.runOnUiThread(new Runnable() {
						public void run() {
							beat(view, radio);
						}
					});
				}
			}

			private void sleep() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	// 按钮模拟心脏跳动
	private static void beat(final View view, final float radio) {

		AnimationSet animationSet = new AnimationSet(true);

		animationSet.addAnimation(new ScaleAnimation(1.0f, radio, 1.0f, radio,

		Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,

		0.5f));

		animationSet.addAnimation(new AlphaAnimation(1.0f, 0.4f));

		animationSet.setDuration(200);

		animationSet.setInterpolator(new AccelerateInterpolator());

		animationSet.setFillAfter(true);

		animationSet.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {

				AnimationSet animationSet = new AnimationSet(true);

				animationSet.addAnimation(new ScaleAnimation(radio, 1.0f, radio,

				1.0f, Animation.RELATIVE_TO_SELF, 0.5f,

				Animation.RELATIVE_TO_SELF, 0.5f));

				animationSet.addAnimation(new AlphaAnimation(0.4f, 1.0f));

				animationSet.setDuration(600);

				animationSet.setInterpolator(new DecelerateInterpolator());

				animationSet.setFillAfter(false);

				// 实现心跳的View

				view.startAnimation(animationSet);

			}

		});

		// 实现心跳的View

		view.startAnimation(animationSet);
	}


	public static void hideProgress(ViewGroup mCover) {
		if (null == mCover)
			return;

		if (mCover.getVisibility() == View.VISIBLE) {
			mCover.setVisibility(View.GONE);
		}
	}
	
	public static boolean showErrorToastCenter(Context context,String msg) {
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		return false;
	}

}
