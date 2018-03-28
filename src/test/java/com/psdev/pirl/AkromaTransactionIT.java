package com.psdev.pirl;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterNumber;

import java.math.BigInteger;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.leftPad;

@Slf4j
@ActiveProfiles("akroma")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AkromaTransactionIT {

    @Autowired
    Web3j web3j;

    DefaultBlockParameter early = DefaultBlockParameter.valueOf(BigInteger.valueOf(407494));
    DefaultBlockParameter later = DefaultBlockParameter.valueOf(BigInteger.valueOf(459515));

    @Test
    public void testGetAllTransactions() throws Exception {
        for (long i = 0; i < 1000; i = i + 100) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            web3j.replayBlocksObservable(
                    new DefaultBlockParameterNumber(BigInteger.valueOf(i)),
                    new DefaultBlockParameterNumber(BigInteger.valueOf(i+100)), false)
                    .subscribe(
                            block -> {
                                System.out.println(
                                        leftPad(block.getBlock().getNumber().toString(), 5, " ") + " "
                                            + leftPad(String.valueOf(block.getBlock().getTransactions().size()), 5, " ") + " "
                                            + block.getBlock().getExtraData() + " "
                                            + block.getBlock().getHash()
                                );
                            },
                            Throwable::printStackTrace,
                            countDownLatch::countDown);
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        }
    }


    public Set<Long> getSection(BigInteger start, BigInteger length) {
        return ContiguousSet.create(
                        Range.open(
                                start.longValue(),
                                start.add(length).longValue()
                        ), DiscreteDomain.longs());

    }

    @After
    public void closeSubscriptions() {

    }

}
