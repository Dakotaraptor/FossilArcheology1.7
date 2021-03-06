package mods.fossil.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.fossil.client.model.ModelConfuciusornis;
import mods.fossil.client.model.ModelFlyingConfuciusornis;
import mods.fossil.client.model.ModelFlyingPteranodon;
import mods.fossil.client.model.ModelPteranodon;
import mods.fossil.entity.mob.EntityConfuciusornis;
import mods.fossil.entity.mob.EntityPterosaur;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderConfuciusornis
  extends RenderLiving
{
  private static final ResourceLocation textureAdult = new ResourceLocation("fossil:textures/mob/Confuciusornis.png");
  private static final ResourceLocation textureBaby = new ResourceLocation("fossil:textures/mob/Confuciusornis_Baby.png");

  public RenderConfuciusornis()
  {
    super(new ModelConfuciusornis(), 0.3F);
  }
  @Override
  protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {	
	  	if(par1EntityLivingBase.isChild()){
	  		GL11.glTranslatef(0, 0, 0.15F);
	  		GL11.glScalef(0.3F, 0.3F, 0.3F);
	  	}else{
	  		GL11.glTranslatef(0, 0, 0.3F);
	  		GL11.glScalef(0.6F, 0.6F, 0.6F);
	  	}
		if (!((EntityConfuciusornis) par1EntityLivingBase).checkGround((EntityConfuciusornis)par1EntityLivingBase)) {
			if (!(this.mainModel instanceof ModelFlyingConfuciusornis)) {
				this.mainModel = new ModelFlyingConfuciusornis();
			}
		}
		else if (this.mainModel instanceof ModelFlyingConfuciusornis) {
			this.mainModel = new ModelConfuciusornis();
		}
	}
  protected ResourceLocation getEntityTextures(EntityConfuciusornis mob)
  {
      if(mob.isChild()){
    	  return textureBaby;

      }else{
    	  return textureAdult;
      }
  
  }
  
  @Override
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityConfuciusornis)entity);
  }
}
