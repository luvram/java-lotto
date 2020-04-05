package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void getRateOfReturn() {
        List<Lotto> lottoList = Collections.singletonList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        WinningLottos winningLottos = new WinningLottos();
        winningLottos
                .addToRank(LottoRank.FIFTH);

        LottoResult lottoResult = new LottoResult(winningLottos, 50000);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(0.1);
    }

    @DisplayName("수익률이 몹시 클 수도 있다.")
    @Test
    void big() {
        WinningLottos winningLottos = new WinningLottos();
        winningLottos.addToRank(LottoRank.FIRST);
        winningLottos.addToRank(LottoRank.FIRST);

        LottoResult lottoResult = new LottoResult(winningLottos, 5000);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(800_000);
    }
}
