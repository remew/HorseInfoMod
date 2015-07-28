package net.remew.mod.horseinfo;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by remew on 2015/07/28.
 */
public class HorseInteractEvent
{
	@SubscribeEvent
	public void callback(EntityInteractEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		if( !player.getEntityWorld().isRemote ) return;

		ItemStack stack = player.getHeldItem();
		if( stack == null || stack.getItem() != Items.stick ) return;
		if( event.target instanceof EntityHorse )
		{
			EntityHorse horse = (EntityHorse)event.target;
			double maxHealth = horse.getMaxHealth();
			double health = horse.getHealth();
			double speed = horse.getEntityAttribute( SharedMonsterAttributes.movementSpeed ).getAttributeValue();
			double jump = horse.getHorseJumpStrength();
			boolean isTame = horse.isTame();

			String HP = String.format("HP    : %.1f/%.1f\n", health, maxHealth);
			String SP = String.format("SPEED : %f\n", speed);
			String JP = String.format("JUMP  : %f\n", jump);
			String remark = isTame ? "This horse is already tamed.\n" : "This horse is not tamed yet.\n";

			StringBuilder sb = new StringBuilder();
			sb.append( "---------------\n" );
			sb.append( HP );
			sb.append( SP );
			sb.append( JP );
			sb.append( remark );
			sb.append( "---------------" );
			player.addChatMessage( new ChatComponentText( sb.toString() ) );
		}
		if(event.isCancelable())
		{
			//System.out.println("canceling");
			event.setCanceled( true );
		}
	}
}
