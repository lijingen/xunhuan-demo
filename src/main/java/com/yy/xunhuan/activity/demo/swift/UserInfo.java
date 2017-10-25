package com.yy.xunhuan.activity.demo.swift;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("UserInfo")
public class UserInfo
{
    public UserInfo() {
    }

    private int ret;

    @ThriftField(value=1, name="ret")
    public int getRet() { return ret; }

    @ThriftField
    public void setRet(final int ret) { this.ret = ret; }

    private long uid;

    @ThriftField(value=2, name="uid")
    public long getUid() { return uid; }

    @ThriftField
    public void setUid(final long uid) { this.uid = uid; }

    private long victory;

    @ThriftField(value=3, name="victory")
    public long getVictory() { return victory; }

    @ThriftField
    public void setVictory(final long victory) { this.victory = victory; }

    private long defeat;

    @ThriftField(value=4, name="defeat")
    public long getDefeat() { return defeat; }

    @ThriftField
    public void setDefeat(final long defeat) { this.defeat = defeat; }

    private long total;

    @ThriftField(value=5, name="total")
    public long getTotal() { return total; }

    @ThriftField
    public void setTotal(final long total) { this.total = total; }

    private long runaway;

    @ThriftField(value=6, name="runaway")
    public long getRunaway() { return runaway; }

    @ThriftField
    public void setRunaway(final long runaway) { this.runaway = runaway; }

    private long failGuard;

    @ThriftField(value=7, name="fail_guard")
    public long getFailGuard() { return failGuard; }

    @ThriftField
    public void setFailGuard(final long failGuard) { this.failGuard = failGuard; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("ret", ret)
            .add("uid", uid)
            .add("victory", victory)
            .add("defeat", defeat)
            .add("total", total)
            .add("runaway", runaway)
            .add("failGuard", failGuard)
            .toString();
    }
}
