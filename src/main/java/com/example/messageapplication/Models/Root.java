package com.example.messageapplication.Models;

import java.util.ArrayList;

class DetectedLanguage{
    public String language;
    public double score;
}

public class Root{
    public DetectedLanguage detectedLanguage;
    public ArrayList<Translation> translations;
}

