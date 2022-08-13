/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("bean.WritingStyle")
@SupportedSourceVersion(SourceVersion.RELEASE_18)
public class SimpleAnnotationProccessor extends AbstractProcessor{

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
        System.out.println("processor is executed");
        for(final Element element : roundEnv.getElementsAnnotatedWith(WritingStyle.class)){
            String varName = element.getSimpleName().toString();
            if(!varName.startsWith("teacher")){
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Deyisen teacher sozu ile baslamir");
                return false;
            }
        }
        return true;
        
    }
    
}
