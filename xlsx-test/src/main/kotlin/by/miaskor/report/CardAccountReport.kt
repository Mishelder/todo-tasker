package by.miaskor.report

import by.miaskor.report.ReportType.CARD_ACCOUNT_488
import by.miaskor.style.StyleCreator
import by.miaskor.style.sheet.SheetAdjuster

class CardAccountReport(
  private val styleCreator: StyleCreator,
  private val sheetAdjuster: SheetAdjuster
) : Report(
  styleCreator = styleCreator,
  sheetAdjuster = sheetAdjuster
) {
  override fun typeReport() = CARD_ACCOUNT_488

  override fun sheetName() = CARD_ACCOUNT_488.sheetName

  override fun headers() = mapOf(
    Pair(0, listOf("ООО МФК \"Мани Мен\"")),
    Pair(
      1,
      listOf("Карточка счета 488 ,48801 ,48802 ,48803 ,48804 ,48805 ,48806 ,48807 ,48808 ,48809 ,48810 ,48811 ,48812 за 2021 г.")
    ),
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