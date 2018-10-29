package com.example.kotlin.service

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.xhtmlrenderer.pdf.ITextRenderer

@Component
class PdfGeneratorUtil {
    @Autowired
    lateinit var templateEngine: TemplateEngine

    fun createPdf(templateName: String, map: Map<String, String?>) {
        val ctx = Context()
        map.forEach { ctx.setVariable(it.key, it.value) }

        val processedHtml = templateEngine.process(templateName, ctx)
        val fileName = UUID.randomUUID().toString()
        val outputFile = File.createTempFile(fileName, ".pdf")
        val os = FileOutputStream(outputFile)

        val renderer = ITextRenderer()
        renderer.setDocumentFromString(processedHtml)
        renderer.layout()
        renderer.createPDF(os, false)
        renderer.finishPDF()
        println("PDF created successfully")
        println(outputFile.absolutePath)

        try {
            os.close()
        } catch (e: IOException) { /*ignore*/
        }
    }
}
