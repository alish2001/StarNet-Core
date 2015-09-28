package com.starnetmc.core.util;

import org.bukkit.ChatColor;

public class TextEffect {

	private String objective;

    private String name;
    private ChatColor currentColor;
    private ChatColor otherColor;
    private ChatColor c33;
    private int index = 0;
    private String open;
    private EffectType type;
    private String close; 
    
    /** @author Redraskal
     * Text Effects
     * Created by Redraskal.
     * 
     * 
     * IMPORTANT:
     * 
     * Blink Effect:
     * Use setWaveColor(ChatColor c);
     * Use setBackgroundColor(ChatColor c);
     * Use setSecondBackgroundColor(ChatColor c);
     * 
     * Type Effect:
     * Use setBackgroundColor(ChatColor c);
     * Use setSecondBackgroundColor(ChatColor c);
     * Use setOpenChar(Character c);
     * Use setCloseChar(Character c);
     * 
     * 
     * USAGE:
     * 
     * TextEffect effect = new TextEffect(String title, EffectType effect);
     * 
     * Set the required effect configurations as seen above.
     * 
     * Use effect.next(); to get the next animated String.
     */
    
    public static enum EffectType {
    	BLINK,
    	TYPE,
    }

    public TextEffect(String title, EffectType effect) {
        this.name = title;
        this.type = effect;
    }
    
    public void setOpenChar(Character c) {
    	this.open = "" + c;
    }
    
    public void setWaveColor(ChatColor c) {
    	this.currentColor = c;
    }
    
    public void setBackgroundColor(ChatColor c) {
    	this.otherColor = c;
    }
    
    public void setSecondBackgroundColor(ChatColor c) {
    	this.c33 = c;
    }
    
    public void setCloseChar(Character c) {
    	this.close = "" + c;
    }
    
    private void nextPBlink() {
    	if (index < name.length() && index > 0) {
                objective = otherColor.toString() + ChatColor.BOLD + name.substring(0, index)
                        + currentColor.toString() + ChatColor.BOLD + name.substring(index, index)
                        +  c33.toString() + ChatColor.BOLD + name.substring(index, index+1)
                + currentColor.toString() + ChatColor.BOLD + name.substring(index+1, name.length());
        }
        if (index == name.length()) {
            objective = otherColor.toString() + ChatColor.BOLD + name.substring( 0, name.length() );
            ChatColor tempColor = currentColor;
            currentColor = otherColor;
            otherColor = tempColor;
        }

        if(index == name.length() + 40) {
              index = 0;
        }
        
        index++;
    }
    
    private void nextPType() {
    	if (index < name.length() && index > 0) {
    		objective = currentColor + "" + ChatColor.BOLD + open + " " + name.substring(0, index) + " " + close;
        }

        if(index == name.length()+10) {
              index = 0;
        }
        
        index++;
    }
    
    public String next() {
         if(type == EffectType.BLINK) {
        	 nextPBlink();
          } else {
             nextPType();
          }
                
         return "" + objective;
    }
}
