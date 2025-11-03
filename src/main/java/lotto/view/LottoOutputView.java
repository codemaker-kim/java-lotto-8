package lotto.view;

import lotto.view.dto.LottoStringDto;

public class LottoOutputView {
    public void lottoCountView(int lottoCount) {
        String message = String.format("%d개를 구매했습니다.", lottoCount);

        System.out.println(message);
    }

    public void lottoView(LottoStringDto dto) {
        dto.lottoNumbers()
                .forEach(System.out::println);
    }
}
