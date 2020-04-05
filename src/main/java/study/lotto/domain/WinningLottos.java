package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottos {
    private List<LottoRank> ranks;

    public WinningLottos() {
        ranks = new ArrayList<>();
    }

    public WinningLottos(List<LottoRank> ranks) {
        this.ranks = new ArrayList<>(ranks);
    }

    protected void addToRank(LottoRank lottoRank) {
        ranks.add(lottoRank);
    }

    public int count(LottoRank lottoRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == lottoRank)
                .count();
    }

    public long getPrizeTotal() {
        return ranks.stream()
                .mapToLong(LottoRank::getPrize)
                .reduce(0, Long::sum);
    }
}
