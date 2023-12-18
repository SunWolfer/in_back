package com.ruoyi.project.network.model;

public class ProtocolConstant {

    public static final int FRAME_SIZE_MIN = 1 + 6 + 1 + 1 + 2 + 2 + 2 + 1;

    public static final int HEAD_DATA = 0x68;

    public static final int MIDDLE_DATA = 0x68;

    public static final int TAIL_DATA = 0x16;

}
