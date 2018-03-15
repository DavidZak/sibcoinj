/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import com.google.common.io.*;
import org.bitcoinj.core.*;
import org.bitcoinj.net.discovery.*;

import java.net.*;

import static com.google.common.base.Preconditions.*;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends AbstractBitcoinNetParams {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.proofOfWorkLimit;
        dumpedPrivateKeyHeader = CoinDefinition.dumpedPrivateKeyHeader;
        addressHeader = CoinDefinition.AddressHeader;
        p2shHeader = CoinDefinition.p2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader};

        port = CoinDefinition.Port;
        packetMagic = CoinDefinition.PacketMagic;

        bip32HeaderPub = 0x0488B21E;    // chainparams.cpp base58Prefixes[EXT_PUBLIC_KEY]
        bip32HeaderPriv = 0x0488ADE4;   // chainparams.cpp base58Prefixes[EXT_SECRET_KEY]

        id = ID_MAINNET;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        spendableCoinbaseDepth = CoinDefinition.spendableCoinbaseDepth;

        CoinDefinition.initCheckpoints(checkpoints);

        dnsSeeds = CoinDefinition.dnsSeeds;

        httpSeeds = null; /*new HttpDiscovery.Details[] {
                new HttpDiscovery.Details(
                        ECKey.fromPublicOnly(BaseEncoding.base16().decode(
                                "027a79143a4de36341494d21b6593015af6b2500e720ad2eda1c0b78165f4f38c4".toUpperCase()
                        )),

                        URI.create("http://main.seed.vinumeris.com/peers")
                )
        };                  */

        addrSeeds = new int[] {
                0xd9b24a4c, 0x63845a45, 0x1d9541bc, 0x239541bc, 0x797a5097,
                0x8a02ff9e, 0xdb676505, 0x6693652e, 0x4431b75f, 0xbc419529,
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    protected void createGenesis(NetworkParameters n) {
        super.createGenesis(n);
        genesisBlock.setDifficultyTarget(CoinDefinition.genesisBlockDifficultyTarget);
        genesisBlock.setTime(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.genesisBlockNonce);

        String genesisHash = genesisBlock.getHashAsString();

        System.out.println("---- genesis hash main ---- " + genesisHash);

        checkState(genesisHash.equals(CoinDefinition.genesisHash));
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
