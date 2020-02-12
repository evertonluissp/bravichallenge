package com.evertonluissp.bravichallenge.services;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.evertonluissp.bravichallenge.utils.StringUtils.removeFirstAndLastCharacter;
import static java.util.regex.Pattern.compile;

@Service
public class BracketsService {

    private static Pattern patternForBrackets = compile("\\[.*\\]");
    private static Pattern patternForBraces = compile("\\{.*\\}");
    private static Pattern patternForParentheses = compile("\\(.*\\)");

    public boolean isBalancedBrackets(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }

        var matcherForBrackets = patternForBrackets.matcher(input);
        String inputIntoBrackets = null;
        if (matcherForBrackets.find()) {
            inputIntoBrackets = removeFirstAndLastCharacter(matcherForBrackets.group());
            input = input.replace(matcherForBrackets.group(), "");
        }

        var matcherForBraces = patternForBraces.matcher(input);
        String inputIntoBraces = null;
        if (matcherForBraces.find()) {
            inputIntoBraces = removeFirstAndLastCharacter(matcherForBraces.group());
            input = input.replace(matcherForBraces.group(), "");
        }

        var matcherForParentheses = patternForParentheses.matcher(input);
        String inputIntoParentheses = null;
        if (matcherForParentheses.find()) {
            inputIntoParentheses = removeFirstAndLastCharacter(matcherForParentheses.group());
            input = input.replace(matcherForParentheses.group(), "");
        }

        return input.isBlank() &&
                isBalancedBrackets(inputIntoBrackets) &&
                isBalancedBrackets(inputIntoBraces) &&
                isBalancedBrackets(inputIntoParentheses);
    }

}
