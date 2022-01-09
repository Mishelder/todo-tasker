package by.miaskor.style.sheet

class CompositeSheetModifier(
  private val mapSheetModifier: Map<String, SheetModifier>
) {

  fun resolveBy(sheetName: String): SheetModifier {
    return mapSheetModifier[sheetName] ?: throw IllegalArgumentException("Sheet creator $sheetName doesn't exist")
  }
}
