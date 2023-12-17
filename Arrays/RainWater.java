package Arrays;
class RainWater {
    public int trap(int[] height) {
        
        int res =0;
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightLoc = 0;

        for(int i=0;i<height.length; i++)
        {
            if(height[i] > maxHeight)
            {
                maxHeight = height[i];
                maxHeightLoc = i;            
            }
        }

        int maxLeft = Integer.MIN_VALUE;

        for(int i=0; i<maxHeightLoc; i++)
        {
            if (height[i] > maxLeft)
            {
                maxLeft = height[i];
            }

            res += (Math.min(maxLeft, maxHeight) - height[i]);
        }

        int maxRight = Integer.MIN_VALUE;

        for(int i= height.length-1; i>maxHeightLoc; i--)
        {
            if(maxRight < height[i])
            {
                maxRight = height[i];
            }

            res += (Math.min(maxHeight, maxRight) - height[i]);
        }
        
        return res;
    }
}