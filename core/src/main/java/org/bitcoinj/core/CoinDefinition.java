package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "Nummi";
    public static final String coinTicker = "NUMMI";
    public static final String coinURIScheme = "nummi";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
        Sibcoin
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Sibcoin;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.dash.org/";    //blockr.io
    //public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://91.228.155.20:3001";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.dash.org/";

    public static final String DONATION_ADDRESS = "Xdeh9YTLNtci5zSL4DDayRSVTLf299n9jv";  //Hash Engineering donation DASH address


    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
        return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
        return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
        return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 33000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    //public static final boolean feeCanBeRaised = false;

    //
    // Dash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70206;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70206;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;


    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 7111;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17111;     //protocol.h GetDefaultPort(testnet=true)
    public static final int RegTestPort = 17222;
    //
    //  Production
    //
    public static final int AddressHeader = 76;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 16;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = true;
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0x1cbdcb4f;


    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1510596000L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (149358);                         //main.cpp: LoadBlockIndex
    //static public String genesisHash = "00000e844873ac38494c38c7f5e1f1fa79d2e334ad8be676e5d8d1db6edaba24"; //main.cpp: hashGenesisBlock
    static public String genesisHash = "00000251edd63ccb47baf6bc379a892f90c567489cff8982fc6ce50f9f545869";
    //static public String genesisMerkleRoot = "f70829504e50b5f779431b63f45df2b3149b287e77800605a2cd45808c1ef3ca";
    static public String genesisMerkleRoot = "160cde32a85bf2731eb2cbdb1c7329a0a8560bc8d2ea30ba4792f464f2fb1cdd";
    static public int genesisBlockValue = 20;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    //static public String genesisTxInBytes = "04ffff001d0104234e756d6d6920446576656c6f706d656e74205374617274732030312f31302f32303137";   //"Nummi Development Starts 01/10/2017"
    static public String genesisTxInBytes = "04c862010e62c8fe06845532b617db0a011a885767f1476d22d9e73e3fabc830a9606df7d4549b25e1162aaee619dbf98d09e53899ada5743aefb8afb7fde3f5bb";

    //TODO FIX ME
    static public String genesisTxOutBytes = "045ba3a70a4366913e0441840f2278d74b154ef4d2dfd0f75a6bf767c3f30a807d9c2595a9b1d2950fe7ee95544145ead55f22e32086c4cc95ee8d3b8aaa6f8929";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
//            "192.168.0.117",
            //"193.124.93.72"
            //"nummi.org",
            "91.228.155.20",
            //"seed.nummi.org",
            "91.228.153.32"
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - dimecoin - not tested
    //
    public static final boolean supportsTestNet = true;
    public static final boolean supportsRegTest = true;    
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final int testnetDumpedPrivateKeyHeader = 125;    
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000798c92e6c1f18a8d4d04757aff2b550c2b3d5980ff46bf8b0a4783d758c";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1516459319L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (1247841L);                         //main.cpp: LoadBlockIndex


    //
    // RegTest
    //
    public static final long regtestPacketMagic = 0xfcc1b7dc;
    public static final String regtestGenesisHash = "00000e769b74a1594b8606402a6af5acd863ac23a3fb67e48ca67eee17d320eb";
    static public long regtestGenesisBlockDifficultyTarget = (0x207fffff);         //main.cpp: LoadBlockIndex
    static public long regtestGenesisBlockTime = 1516459320L;                       //main.cpp: LoadBlockIndex
    static public long regtestGenesisBlockNonce = (234714L);



    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            //"testnet-seed.sibcoin.net",
//            "testnet-seed.darkcoin.qa",
//            "23.23.186.131"
            //"nummi.org",
            "91.228.155.20",
            //"seed.nummi.org",
            "91.228.153.32"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "0426af3a693d83e45eca2c3faab1157c0294ac7de5b0ae4cefe8d2b98370a8f50ef1653fb46142d7d2cae61cdb57f628193df1a55f49f547458ab909210fcd5cde";
    public static final String TESTNET_SATOSHI_KEY = "0479d64291075c43fc83578afd519b1bc6944332f0d9f7631393113d2cbe125160997da610dc948d4dd1e5ce53552f6242eaa7b97c0da48f82c2531a91191e8336";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.nummi.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.nummi.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        //checkpoints.put(  0, Sha256Hash.wrap("0000070a1e74f3551aa25c0354e2761e5d6d8a5558bd4ddf3f69cc9def500547"));
        checkpoints.put(0, Sha256Hash.wrap("00000251edd63ccb47baf6bc379a892f90c567489cff8982fc6ce50f9f545869"));
    }

    //checkpoints.cpp Checkpoints::mapCheckpointsTestnet
    public static void initTestnetCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(0, Sha256Hash.wrap("00000798c92e6c1f18a8d4d04757aff2b550c2b3d5980ff46bf8b0a4783d758c"));
    }

    //checkpoints.cpp Checkpoints::mapCheckpointsRegtest
    public static void initRegtestCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(0, Sha256Hash.wrap("00000e769b74a1594b8606402a6af5acd863ac23a3fb67e48ca67eee17d320eb"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";
}
