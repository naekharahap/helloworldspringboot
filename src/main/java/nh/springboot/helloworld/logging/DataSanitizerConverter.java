package nh.springboot.helloworld.logging;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
@Plugin(name = "DataSanitizerConverter", category = "Converter")
@ConverterKeys({"sanitize"})
public class DataSanitizerConverter extends LogEventPatternConverter {

    private final PatternLayout patternLayout;

    protected DataSanitizerConverter(String[] options) {
        super("sanitize", "sanitize");
        this.patternLayout = createPatternLayout(options);
    }

    public static DataSanitizerConverter newInstance(String[] options) {
        return new DataSanitizerConverter(options);
    }

    private PatternLayout createPatternLayout(String[] options) {
        if (options == null || options.length == 0) {
            throw new IllegalArgumentException("Options for DataSanitizerConverter are missing.");
        }
        return PatternLayout.newBuilder().withPattern(options[0]).build();
    }

    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        String formattedMessage = patternLayout.toSerializable(event);
        String maskedMessage = maskSensitiveValues(formattedMessage);
        toAppendTo.setLength(0);
        toAppendTo.append(maskedMessage);
    }

    private String maskSensitiveValues(String message) {
        // Replace sensitive values with masked value
        message = message.replaceAll("(?<=username[=:]).+", "***");
        message = message.replaceAll("(?<=creditCardNumber[=:]).+", "***");
        
        return message;
    }
}