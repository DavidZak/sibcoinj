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


    public static final String coinName = "Sibcoin";
    public static final String coinTicker = "SIB";
    public static final String coinURIScheme = "sibcoin";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[5]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[KL]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chain.sibcoin.net/api/unspent/";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
        Sibcoin,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Sibcoin;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://chain.sibcoin.net/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://testchain.sibcoin.net/";

    public static final String DONATION_ADDRESS = "Sibf9n93ZqPePPdZhLNExCNa284dexP8F5";  //RusApps donation SIB address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //36 blocks

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
    public static final long MAX_COINS = 22000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 100000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 1000; //main.h CTransaction::GetMinFee        0.01 coins
    public static final long INSTANTX_FEE = 1000000;

    //
    // Dash 0.12
    //
    public static final int PROTOCOL_VERSION = 70103;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70066;        //version.h MIN_PROTO_VERSION
    public static final int BIP0031_VERSION = 60000;

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 1945;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 11945;     //protocol.h GetDefaultPort(testnet=true)
    public static final int RegTestPort = 19994;

    //
    //  Production
    //
    public static final int AddressHeader = 63;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 40;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final boolean allowBitcoinPrivateKey = true; //for backward compatibility with previous version of digitalcoin
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xbf0c6bbd;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1431122400L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (1394136);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000c492bf73490420868bc577680bfc4c60116e7e85343bc624787c21efa4c"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "6a35812a1d2dd4ec413b7de5870c56455110ad6395ef00962e58f812da7cb4b9";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01042f52542e434f4d2030382f4d61792f3230313520576f726c64206d61726b73205757494920766963746f727920646179";   // chainparams.cpp : txNew.vin[0].scriptSig.ToString()
    static public String genesisTxOutBytes = "04a31424abc548189ddce601561b2691d8b9b8551cc45522d06656b67ee062b84d4c6d6e142b05b87237b0e0ddadf9d6978bc0243def2210067c43890adbcb030d";  // chainparams.cpp : txNew.vout[0].scriptPubKey.ToString()

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed.sibcoin.net",
            "dnsseed.chervonec.info",
            "dnsseed1.darknode.ru",
            "dnsseed2.darknode.ru",
            "dnsseed3.darknode.ru",
            //"23.23.186.131", //Evan's seed node
            //"162.252.83.46",  //drkpool.com
            /*"107.155.71.72",
            "50.16.206.102",
            "50.19.116.123",
            "98.165.130.67",
            "23.23.186.131",
            "50.16.206.102",
            "50.19.116.123",
            "50.19.116.123",
            "23.21.204.34",
            "188.142.39.105",
            "50.16.206.102", //InternetApe's seed node
            "23.23.186.131",
            "50.19.116.123",
            "54.248.227.151",
            "42.121.58.91",
            "50.81.192.39",
            "54.193.124.32",
            "62.141.39.175",
            "5.254.96.3",
            "175.115.201.44",
            "208.53.191.2",
            "162.243.33.16",*/
    };

    public static int minBroadcastConnections = 0;   //0 for default; we need more peers.

    //
    // TestNet - dimecoin - not tested
    //
    public static final boolean supportsTestNet = true;
    public static final boolean supportsRegTest = true;
    public static final int testnetAddressHeader = 125;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 100;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final int testnetDumpedPrivateKeyHeader = 125;
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000617791d0e19f524387f67e558b2a928b670b9a3b387ae003ad7f9093017";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1431129600L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (2308058L);                         //main.cpp: LoadBlockIndex


    //
    // RegTest
    //
    public static final long regtestPacketMagic = 0xfcc1b7dc;
    public static final String regtestGenesisHash = "000007bfa2866f77d1f22f9da7fda73ea3c5185dc156f4f6f8b3a3caed27247e";
    static public long regtestGenesisBlockDifficultyTarget = (0x207fffff);         //main.cpp: LoadBlockIndex
    static public long regtestGenesisBlockTime = 1431129600L;                       //main.cpp: LoadBlockIndex
    static public long regtestGenesisBlockNonce = (2106393);



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
            "testnet-seed.sibcoin.net",
//            "testnet-seed.darkcoin.qa",
//            "23.23.186.131"
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "046e165af8bee5294a27bfcec06d5828399d442761e4ebf4296c38d4dbe891e15dc16df5254347833dcfc1c2c1b8d5473ccdccac2896b4783f47fe53eb45c8ac8c";
    public static final String TESTNET_SATOSHI_KEY = "041ce46b0192442eb3b504a18bcf70c088e25957c37613ab2fa9207df75387665ce939cb9c73daa3bf18f3c8ead430817c68dbc7e22e1545dd149faa408b7745ce";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.sibcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.sibcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(    0, Sha256Hash.wrap("00000c492bf73490420868bc577680bfc4c60116e7e85343bc624787c21efa4c"));
        checkpoints.put( 1000, Sha256Hash.wrap("000004051b89a63d2ed190863a4333ff01aa27e65f1b4b7644e279d9d3587e07"));
        checkpoints.put( 5000, Sha256Hash.wrap("0000013ce4f5d0a624391cda2e3fe5d7ced85603f51370563f9a27dbcc5c7f45"));
        checkpoints.put(10000, Sha256Hash.wrap("000000f59e97128ac36be3597142acdc0ae64e4b2d8d31cd990fd341d94c6782"));
        checkpoints.put(15000, Sha256Hash.wrap("0000008deaa8e017c246ef7ecebc4c9f24615691a19918379aad7170c32e19ef"));
        checkpoints.put(20000, Sha256Hash.wrap("0000001d2ff5a5fcf62191ed47ba73127f5884f7a53276cdfbc15afd65bd99d2"));
        checkpoints.put(25000, Sha256Hash.wrap("0000006774f19670a0e9e7dbd7ec380ff5b4d8d8130dae68bc9d4840e277973f"));
        checkpoints.put(30000, Sha256Hash.wrap("0000007f8622cde9424e5a7e9bd86aefe844b43e20343bcde69a7d3cb9cc640d"));
        checkpoints.put(35000, Sha256Hash.wrap("000000160f53facbb70193a3dac0357331520eb9e4fb544ac33a96b81c5ea890"));
        checkpoints.put(38700, Sha256Hash.wrap("0000000922c8ae23533c8aa6a4a22f51fa4cdfba85e8c08f2a019dcf755ec48f"));
        checkpoints.put(70000, Sha256Hash.wrap("00000000013eb4498b627e9b8cc1baf74f77f518be4f32ed27b6455e18f5295a"));
        checkpoints.put(80000, Sha256Hash.wrap("0000000027d43f7c0323d29365f18c39666b8205a160d8a09f599f92ff259482"));
    }

    //checkpoints.cpp Checkpoints::mapCheckpointsTestnet
    public static void initTestnetCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(    0, Sha256Hash.wrap("00000617791d0e19f524387f67e558b2a928b670b9a3b387ae003ad7f9093017"));
        checkpoints.put( 1500, Sha256Hash.wrap("0000031c5def292029d4713891fc26e5b4559aff101ce2cf6348418d028daf11"));
        checkpoints.put( 5650, Sha256Hash.wrap("000000131d2a832c254b06d37ee035a5a92d4266b3e489ed1ecb185e4f06ea0f"));
    }

    //checkpoints.cpp Checkpoints::mapCheckpointsRegtest
    public static void initRegtestCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(    0, Sha256Hash.wrap("000007bfa2866f77d1f22f9da7fda73ea3c5185dc156f4f6f8b3a3caed27247e"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
