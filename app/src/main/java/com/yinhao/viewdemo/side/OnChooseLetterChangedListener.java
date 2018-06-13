package com.yinhao.viewdemo.side;

public interface OnChooseLetterChangedListener {
    /**
     * 滑动时
     *
     * @param s
     */
    void onChooseLetter(String s);

    /**
     * 手指离开
     */
    void onNoChooseLetter();
}
