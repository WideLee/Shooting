﻿package com.android13.shooting.res;

import com.android13.shooting.Game;
import com.android13.shooting.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

/**
 * 管理游戏的位图资源
 * 
 * @author 11331197 林家访 <98905067@qq.com>
 * @author 11331173 李明宽 <sysu_limingkuan@163.com>
 * @author 11331185 连凌淦 <839021322@qq.com>
 * 
 */
public class BitmapPool {

	private static SparseArray<Bitmap> pool = null;

	public static void loadAll(Context context) {
		pool = new SparseArray<Bitmap>();

		Resources res = context.getResources();
		/** 先载入原图，再根据屏幕规格进行缩放，并存入pool中 */

		// 篮板
		Bitmap bb = BitmapFactory.decodeResource(res, R.drawable.backboard);
		pool.put(R.drawable.backboard, Bitmap.createScaledBitmap(bb,
				(int) Game.Constant.BACKBOARD_WIDHT, (int) Game.Constant.BACKBOARD_HEIGHT, true));
		bb.recycle();
		bb = null;
		// 背景
		Bitmap bg = BitmapFactory.decodeResource(res, R.drawable.background);
		pool.put(R.drawable.background, Bitmap.createScaledBitmap(bg,
				(int) Game.Constant.SCREEN_WIDTH, (int) Game.Constant.SCREEN_HEIGHT, true));
		bg.recycle();
		bg = null;
		// 篮筐
		for (int i = 0; i < 5; ++i) {
			Bitmap hoop = BitmapFactory.decodeResource(res, R.drawable.hoop00 + i);
			pool.put(R.drawable.hoop00 + i, Bitmap.createScaledBitmap(hoop,
					(int) Game.Constant.HOOP_WIDTH, (int) Game.Constant.HOOP_HEIGHT, true));
			hoop.recycle();
			hoop = null;
		}

		// 篮球
		for (int i = 0; i < 5; ++i) {
			Bitmap ball = BitmapFactory.decodeResource(res, R.drawable.ball000 + i);
			pool.put(R.drawable.ball000 + i, Bitmap.createScaledBitmap(ball,
					(int) Game.Constant.BALL_RADIUS * 2, (int) Game.Constant.BALL_RADIUS * 2, true));
			ball.recycle();
			ball = null;
		}

		// 叶子
		Bitmap leaf = BitmapFactory.decodeResource(res, R.drawable.leaf);
		pool.put(R.drawable.leaf, Bitmap.createScaledBitmap(leaf, (int) Game.Constant.LEAF_WIDTH,
				(int) Game.Constant.LEAF_HEIGHT, true));
		leaf.recycle();
		leaf = null;

		// 时间字样"time："
		Bitmap time = BitmapFactory.decodeResource(res, R.drawable.time);
		pool.put(R.drawable.time, Bitmap.createScaledBitmap(time,
				(int) (Game.Constant.TIME_NUM_WIDTH * 3.5f), (int) Game.Constant.TIME_NUM_HEIGHT,
				true));
		time.recycle();
		time = null;

		// 时间数字
		for (int i = 0; i < 10; ++i) {
			Bitmap timeNum = BitmapFactory.decodeResource(res, R.drawable.time0 + i);
			pool.put(R.drawable.time0 + i, Bitmap.createScaledBitmap(timeNum,
					(int) Game.Constant.TIME_NUM_WIDTH, (int) Game.Constant.TIME_NUM_HEIGHT, true));
			timeNum.recycle();
			timeNum = null;
		}

		// 分数数字
		for (int i = 0; i < 10; ++i) {
			Bitmap scoreNum = BitmapFactory.decodeResource(res, R.drawable.score0 + i);
			pool.put(R.drawable.score0 + i, Bitmap
					.createScaledBitmap(scoreNum, (int) Game.Constant.SCORE_NUM_WIDTH,
							(int) Game.Constant.SCORE_NUM_HEIGHT, true));
			scoreNum.recycle();
			scoreNum = null;
		}

		// 进球提示
		for (int i = 0; i < 2; ++i) {
			Bitmap hint = BitmapFactory.decodeResource(res, R.drawable.hint0 + i);
			pool.put(R.drawable.hint0 + i, Bitmap.createScaledBitmap(hint,
					(int) Game.Constant.HINT_WIDTH, (int) Game.Constant.HINT_HEIGHT, true));
			hint.recycle();
			hint = null;
		}

		// 关卡的数字
		for (int i = 0; i < 4; i++) {
			Bitmap level = BitmapFactory.decodeResource(res, R.drawable.level1 + i);
			pool.put(R.drawable.level1 + i, Bitmap.createScaledBitmap(level,
					(int) Game.Constant.LEVEL_WIDTH, (int) Game.Constant.LEVEL_HEIGHT, true));
			level.recycle();
			level = null;
		}

		// 关卡字样"Level:"
		Bitmap level = BitmapFactory.decodeResource(res, R.drawable.level);
		pool.put(R.drawable.level, Bitmap.createScaledBitmap(level,
				(int) Game.Constant.LEVEL_WIDTH * 5, (int) Game.Constant.LEVEL_HEIGHT, true));
		level.recycle();
		level = null;
	}

	/**
	 * 游戏中获取相应的BitMap位图资源
	 * @param what
	 *            要获取的BitMap的id
	 * @return 需要的BitMap，如果不存在则返回null
	 */
	public static Bitmap getBitmap(int what) {
		if (null == pool)
			return null;
		return pool.get(what);
	}
}
