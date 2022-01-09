package by.miaskor.builder

import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class FontBuilder {

  fun createFont(workbook: XSSFWorkbook): Font {
    return Font(workbook.createFont())
  }

  class Font(
    private val font: XSSFFont
  ) {

    fun bold(isBold: Boolean): Font {
      font.bold = isBold
      return this
    }

    fun italic(isItalic: Boolean): Font {
      font.italic = isItalic
      return this
    }

    fun fontName(fontName: String): Font {
      font.fontName = fontName
      return this
    }

    fun fontSize(fontSize: Int): Font {
      font.fontHeightInPoints = fontSize.toShort()
      return this
    }

    fun build(): XSSFFont {
      return font
    }
  }
}
