package by.miaskor.report

import by.miaskor.report.ReportType.CARD_ACCOUNT_61217_CESSION
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class CardAccountCessionReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = CARD_ACCOUNT_61217_CESSION

  override fun sheetName() = CARD_ACCOUNT_61217_CESSION.sheetName

  override fun headers() = mapOf(
    Pair(0, listOf("ООО МФК \"Мани Мен\"")),
    Pair(1, listOf("Карточка счета 61217 за Июль 2021 г. (ЦЕССИЯ)")),
    Pair(
      2, listOf(
        "Период",
        "Документ",
        "Аналитика Дт",
        "Аналитика Кт",
        "Показатель",
        "Дебет",
        "Кредит",
        "Текущее сальдо",
      )
    ),
    Pair(
      3, listOf(
        "Сальдо на начало",
        "Счет",
        "Счет",
      )
    )
  )

  override fun cellValues() = mapOf<Int, List<String>>()
}
