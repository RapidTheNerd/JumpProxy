package me.rtn.jump.commands;

import me.rtn.jump.util.ChatUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/*
 * Jump
 * Copyright (C) 2017 RapidTheNerd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class MessageCommand extends Command {

    public MessageCommand(){
        super("msg", "jumpproxy.command.msg", "w", "m", "r");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        String messageFormat = "&9[✉]&f&l»";

        if(commandSender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if(args.length == 0){
                player.sendMessage(ChatUtil.format("&c Invalid message"));
                return;
            }

            String targetString = args[0];
            if(ProxyServer.getInstance().getPlayer(targetString) == null){
                player.sendMessage(ChatUtil.format("&cPlayer offline"));
            }

            if(checkIfArguementIsNull(args, 1)){

            }
        }
    }
    private boolean checkIfArguementIsNull(String[] args, int index){
        try {
            String temp = args[index];
            return false;
        }catch(IndexOutOfBoundsException e){
            return true;
        }
    }
}
