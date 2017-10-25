package com.yy.xunhuan.activity.demo.swift;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.Map;

@ThriftService("XHRecordService")
public interface XHRecordService
{
    @ThriftService("XHRecordService")
    public interface Async
    {
        @ThriftMethod(value = "QueryUserRecord")
        ListenableFuture<UserInfo> QueryUserRecord(
                @ThriftField(value = 1, name = "uid") final long uid
        );

        @ThriftMethod(value = "GetUserRecordByGameMode")
        ListenableFuture<UserInfo> GetUserRecordByGameMode(
                @ThriftField(value = 1, name = "uid") final long uid,
                @ThriftField(value = 2, name = "gameMode") final PWerwolfEGameMode gameMode
        );

        @ThriftMethod(value = "GetUserRecordByGameModes")
        ListenableFuture<Map<PWerwolfEGameMode, UserInfo>> GetUserRecordByGameModes(
                @ThriftField(value = 1, name = "uid") final long uid,
                @ThriftField(value = 2, name = "gameModes") final List<PWerwolfEGameMode> gameModes
        );

        @ThriftMethod(value = "QueryIsNewUser")
        ListenableFuture<Long> QueryIsNewUser(
                @ThriftField(value = 1, name = "uid") final long uid
        );
    }
    @ThriftMethod(value = "QueryUserRecord")
    UserInfo QueryUserRecord(
            @ThriftField(value = 1, name = "uid") final long uid
    ) throws com.yy.cs.center.remoting.RemotingException;

    @ThriftMethod(value = "GetUserRecordByGameMode")
    UserInfo GetUserRecordByGameMode(
            @ThriftField(value = 1, name = "uid") final long uid,
            @ThriftField(value = 2, name = "gameMode") final PWerwolfEGameMode gameMode
    ) throws com.yy.cs.center.remoting.RemotingException;

    @ThriftMethod(value = "GetUserRecordByGameModes")
    Map<PWerwolfEGameMode, UserInfo> GetUserRecordByGameModes(
            @ThriftField(value = 1, name = "uid") final long uid,
            @ThriftField(value = 2, name = "gameModes") final List<PWerwolfEGameMode> gameModes
    ) throws com.yy.cs.center.remoting.RemotingException;

    @ThriftMethod(value = "QueryIsNewUser")
    long QueryIsNewUser(
            @ThriftField(value = 1, name = "uid") final long uid
    ) throws com.yy.cs.center.remoting.RemotingException;
}